package com.seckill.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tao.hong
 */
@Data
@Component
@ConfigurationProperties(prefix = "skip.url")
public class NonAuthUrls {

    private List<String> nonAuthUrls;

}
