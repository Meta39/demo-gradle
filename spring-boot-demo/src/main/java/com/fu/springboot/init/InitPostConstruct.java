package com.fu.springboot.init;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * 如不涉及需要启动后执行的内容，Spring 官方推荐使用 @PostConstruct 初始化 bean
 */
@Component
public class InitPostConstruct {

    /**
     * 在Bean的构造方法执行完毕后，执行一些初始化操作，如读取配置文件信息、数据库连接、删除临时文件、清除缓存信息、工厂类初始化等。
     * 这时Spring Boot并没有启动完全，如果此时获取没有初始化的 bean，很有可能会报空指针异常。因此通常用于不涉及其他 bean 的初始化。
     * 如果需要在 Spring Boot 启动完成后执行某个方法，应当实现 CommandLineRunner 或 ApplicationRunner（推荐） 接口。
     */
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct init one.");
    }

    /**
     * 销毁程序时执行
     */
    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy destroy success.");
    }

}
