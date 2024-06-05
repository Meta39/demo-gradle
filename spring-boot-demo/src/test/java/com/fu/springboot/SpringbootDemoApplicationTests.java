package com.fu.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    private RestClient restClient;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void test(){
        try{
            ResponseEntity<String> response = restTemplate.getForEntity("http://127.0.0.1:82/test", String.class);
            log.info("body:{}", response.getBody());
        } catch (HttpStatusCodeException e) {
            log.error("HTTP Code:{}, Error Message: {}", e.getStatusCode().value(), e.getMessage());
        }
    }

    @Test
    void test1(){
        //因为已经在 RestClient 配置了 baseUrl，直接写uri即可。直接转 String 可能会乱码。稳妥办法先转 byte[] 再设置编码为 UTF-8 转 String
        byte[] bodyByte = restClient.get().uri("/test").retrieve().body(byte[].class);
        String bodyString = new String(bodyByte, StandardCharsets.UTF_8);
        log.info("bodyString:{}", bodyString);
    }

}
