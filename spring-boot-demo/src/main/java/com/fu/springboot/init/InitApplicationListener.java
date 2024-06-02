package com.fu.springboot.init;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationListener用于监听Spring Boot应用程序事件，并不作为启动之后执行某个方法
 * 注意：如果不是监听应用事件，通常不建议使用这种方式初始化。
 */
@Component
public class InitApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("ApplicationListener init two.");
    }

}
