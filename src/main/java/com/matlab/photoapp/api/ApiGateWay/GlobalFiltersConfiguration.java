package com.matlab.photoapp.api.ApiGateWay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {
    final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);

    @Bean
    @Order(1)
    public GlobalFilter secondPrefilter(){
        return ((exchange, chain) -> {
            logger.info(".........---My second global pre-filter is executed...(Order-1)");
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("---... My Second global post-filter is executed...!!!(Order-1)");
            }));
        });
    }

    @Bean
    @Order(2)
    public GlobalFilter thirdPrefilter(){
        return ((exchange, chain) -> {
            logger.info(".........---My third global pre-filter is executed...(Order-2)");
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("---... My Third global post-filter is executed...!!!(Order-2)");
            }));
        });
    }

    @Bean
    @Order(3)
    public GlobalFilter fourthPrefilter(){
        return ((exchange, chain) -> {
            logger.info(".........---My fourth global pre-filter is executed...(Order-3)");
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("---... My fourth global post-filter is executed...!!!(Order-3)");
            }));
        });
    }
}
