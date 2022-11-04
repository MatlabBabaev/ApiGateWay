package com.matlab.photoapp.api.ApiGateWay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyPostFilter implements GlobalFilter, Ordered {

    final Logger logger = LoggerFactory.getLogger(MyPostFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("THe LAST Global post filter executed!!!");
        }));
    }

    @Override//It will be implemented last
    public int getOrder() {
        return 0;
    }
}
