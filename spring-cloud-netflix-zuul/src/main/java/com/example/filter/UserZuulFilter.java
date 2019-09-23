package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserZuulFilter extends ZuulFilter {
    /**
     * 过滤类型，4个字符串常量值
     * pre 路由之前
     * routing 路由之时
     * post 路由之后
     * error 发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，数字越小执行越靠前
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤业务的具体代码
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        // 放行
        context.setSendZuulResponse(true);
        return null;
    }
}
