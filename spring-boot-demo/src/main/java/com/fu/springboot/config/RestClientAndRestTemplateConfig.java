package com.fu.springboot.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

/**
 * RestClient 和 RestTemplate http 客户端配置
 */
@Configuration
public class RestClientAndRestTemplateConfig {

    /**
     * Spring 新一代 http 客户端
     */
    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://127.0.0.1:82")
                .requestFactory(new HttpComponentsClientHttpRequestFactory(HttpClients.custom()
                        .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                                .setMaxConnTotal(100) // 最大连接数，默认：25个
                                .setMaxConnPerRoute(10)// 每个路由的最大连接数，默认：5个
                                .build()
                        )
                        .setDefaultRequestConfig(RequestConfig.custom()
                                .setConnectionRequestTimeout(Timeout.ofMinutes(1))// 连接超时时间，默认：3分钟
                                .setResponseTimeout(Timeout.ofMinutes(1))// 设置响应超时时间，默认：3分钟
                                .build())
                        .build()))
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        // 创建连接池管理器
        PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setMaxConnTotal(100) // 最大连接数，默认：25个
                .setMaxConnPerRoute(10)// 每个路由的最大连接数，默认：5个
                .build();

        // 请求配置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMinutes(1))// 连接超时时间，默认：3分钟
                .setResponseTimeout(Timeout.ofMinutes(1))// 设置响应超时时间，默认：3分钟
                .build();

        // 创建HttpClient对象
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(client);
    }

}