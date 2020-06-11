package com.seckill.filter;

import com.seckill.config.NonAuthUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import seckill.common.api.ResultCode;
import seckill.common.exception.GateWayException;

/**
 * 全局过滤器
 */
@Component
public class TokenValidateGlobalFilter implements GlobalFilter {

    @Autowired
    private NonAuthUrls nonAuthUrls;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if(shouldSkip(exchange.getRequest().getURI().getPath())){
            return chain.filter(exchange);
        }
        String authHeader = exchange.getRequest().getHeaders().getFirst("authorization");
        if(StringUtils.isEmpty(authHeader)){
           throw new GateWayException(ResultCode.AUTHORIZATION_HEADER_IS_EMPTY);
        }
        // todo 判断是否有用户登陆，没有的话去登陆鉴权
        return exchange.getResponse().setComplete();
    }

    private boolean shouldSkip(String currentUrl) {
        PathMatcher pathMatcher = new AntPathMatcher();
        for(String skipPath : nonAuthUrls.getNonAuthUrls()) {
            if(pathMatcher.match(skipPath,currentUrl)) {
                return true;
            }
        }
        return false;
    }

}
