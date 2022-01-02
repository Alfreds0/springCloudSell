package com.imocc.apigaetway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.imocc.apigaetway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 令牌桶限流
 * @author admin
 */
@Component
public class RateLimitFilter extends ZuulFilter {
    //每秒钟放多少个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //没有获取到令牌，抛异常或返回http状态码
        if(!RATE_LIMITER.tryAcquire()){
            throw new RateLimitException();
        }

        return null;
    }
}
