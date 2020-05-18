package com.seckill.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 手动配置
 */
@Configuration
public class RouteLocatorConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return  builder.routes()
//                .route(r -> r.host("**.yuqiyu.com")
//                        .and().path("/api-boot-datasource-switch.html")
//                        .and().method("GET")
//                        .uri("http://blog.yuqiyu.com")
//                        .order(1)
//                        .id("blog")
//                )
//                .build();
//    }
}
