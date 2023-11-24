package com.fu.springboot.global;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fu.springboot.exceptions.BaseException;
import com.fu.springboot.exceptions.custom.MiniProgramException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * 全局返回和异常处理类
 */
@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static final Logger log = LoggerFactory.getLogger(GlobalResponseBodyAdvice.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //------------------------------------------------------ 自定义异常状态码的异常 ----------------------------------------

    /**
     * 小程序异常状态码和异常信息
     * @param e BaseException
     */
    @ExceptionHandler(value = MiniProgramException.class)
    public Res<?> miniProgramException(MiniProgramException e) {
        log.error("MiniProgramException", e);
        return new Res<>(e.getStatus(), e.getMessage());
    }

    /**
     * 自定义异常状态码和异常信息
     * @param e BaseException
     */
    @ExceptionHandler(value = BaseException.class)
    public Res<?> baseException(BaseException e) {
        log.error("BaseException", e);
        return new Res<>(e.getStatus(), e.getMessage());
    }

    //------------------------------------------------------ 非自定义异常状态码的异常 --------------------------------------

    /**
     * RequestParam注解请求参数异常（不需要记录到日志）
     * 这里是最终返回，不能抛出异常，如果抛出异常就无法返回给前端信息了
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Res<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new Res<>(Res.DEFAULT_FAIL_CODE, e.getMessage());
    }

    /**
     * validation参数校验（不需要记录到日志）
     * 这里是最终返回，不能抛出异常，如果抛出异常就无法返回给前端信息了
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Res<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new Res<>(Res.DEFAULT_FAIL_CODE, e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(";")));
    }

    /**
     * 服务器异常（需要记录到日志）
     * 这里是最终返回，不能抛出异常，如果抛出异常就无法返回给前端信息了
     */
    @ExceptionHandler(value = Exception.class)
    public Res<?> exception(Exception e) {
        log.error("Exception", e);
        return new Res<>(Res.DEFAULT_FAIL_CODE, e.getMessage());
    }

    //-----------------------------------------------有新的异常在上面加--------------------------------------------------------

    //-----------------------------------------------下面是全局返回-----------------------------------------------------------

    /**
     * 是否把返回内容存放到Res返回给前端
     *
     * @param returnType    返回类型
     * @param converterType 转换器类型
     */
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 把返回内容存放到Res返回给前端
     * 这里也是最终返回，不能抛出异常，如果抛出异常就无法返回给前端信息了
     *
     * @param body       原始数据
     * @param returnType 原始返回给前端的数据类型
     * @param request    请求
     * @param response   响应
     */
    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        if (body instanceof String) {//String类型要特殊处理
            try {
                return objectMapper.writeValueAsString(new Res<>(body));
            } catch (JsonProcessingException e) {
                log.error("beforeBodyWrite JSON 解析异常", e);
                return new Res<>(Res.DEFAULT_FAIL_CODE, "beforeBodyWrite JSON 解析异常");
            }
        } else if (body instanceof Res) {//本身是Res直接返回即可。例如：全局异常处理，返回的就是Res
            return body;
        } else if (body instanceof LinkedHashMap<?, ?> map && (map.containsKey("status") && map.containsKey("error") && map.containsKey("message"))) {
            //解决404、500等spring没有捕获的异常问题，只能放到最后的判断条件去判断。如果LinkedHashMap包含status状态码的key，则抛出异常。
            log.error("beforeBodyWrite捕获到spring没有捕获的异常问题：{}", map);
            String errorMessage = "error：" + map.get("error") + ",message：" + map.get("message") + ",path：" + map.get("path");
            return new Res<>((Integer) map.get("status"), errorMessage);
        }
        return new Res<>(body);
    }

}