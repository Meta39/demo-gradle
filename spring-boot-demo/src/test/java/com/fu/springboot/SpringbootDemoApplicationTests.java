package com.fu.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootTest
public class SpringbootDemoApplicationTests {
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

}
