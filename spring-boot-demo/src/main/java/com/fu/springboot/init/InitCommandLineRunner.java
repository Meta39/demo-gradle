package com.fu.springboot.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 在Spring Boot应用程序启动完成后，执行一次所有实现了CommandLineRunner接口的类的run方法。
 */
@Component
public class InitCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner init three.");
    }

}
