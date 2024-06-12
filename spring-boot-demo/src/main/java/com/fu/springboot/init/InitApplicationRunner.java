package com.fu.springboot.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 需要在启动Spring Boot后执行某些方法时，推荐使用此方式
 * 与CommandLineRunner类似，但接受参数： ApplicationRunner接口与CommandLineRunner类似，但run方法接受一个ApplicationArguments对象作为参数，可以访问命令行参数。
 * 如：初始化数据库、加载配置文件等： 可以在应用启动后执行一些需要命令行参数的操作，如根据命令行参数初始化数据库、加载外部的配置文件等。
 */
@Component
public class InitApplicationRunner implements ApplicationRunner {
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("spring.profiles.active = " + activeProfile);
    }

}
