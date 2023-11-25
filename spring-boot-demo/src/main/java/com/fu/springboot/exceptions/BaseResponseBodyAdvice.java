package com.fu.springboot.exceptions;

import com.fu.springboot.exceptions.custom.MiniProgramException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局返回和异常处理类
 */
@RestControllerAdvice
public class BaseResponseBodyAdvice {
    private static final Logger log = LoggerFactory.getLogger(BaseResponseBodyAdvice.class);

    //------------------------------ 需要其它异常状态码的异常（默认code非500） ------------------------------
    /**
     * 未认证异常
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)//code = 401
    public String usernameNotFoundException(UnauthorizedException e) {
        log.error("UsernameNotFoundException", e);
        return e.getMessage();
    }

    /**
     * 未鉴权异常
     */
    @ExceptionHandler(value = ForbiddenException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)//code = 403
    public String usernameNotFoundException(ForbiddenException e) {
        log.error("ForbiddenException", e);
        return e.getMessage();
    }

    //------------------------------ 不需要其它异常状态码的异常（默认code为500）【但是需求区分异常来源的，如：小程序的异常等】 ------------------------------
    /**
     * 小程序异常状态码和异常信息
     */
    @ExceptionHandler(value = MiniProgramException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)//code = 500
    public String miniProgramException(MiniProgramException e) {
        log.error("MiniProgramException", e);
        return e.getMessage();
    }

    //------------------------------ RuntimeException一定是放到Exception前面的 ------------------------------
    /**
     * 运行时异常
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)//code = 500
    public String runtimeException(RuntimeException e) {
        log.error("RuntimeException", e);
        return e.getMessage();
    }

    //------------------------------ Exception一定是放到最下面的 ------------------------------
    /**
     * Exception（这个一定是放到最后的）
     * 这个是前面的异常都没有捕获到，则会变成Exception，如果前面捕获到了，则会在前面显示。
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)//code = 500
    public String exception(Exception e) {
        log.error("Exception", e);
        return e.getMessage();
    }

}