package com.scau.shop.config;

import com.scau.shop.interceptor.LoginInterCeptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//注册处理器拦截器
//@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterCeptor loginInterCeptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 白名单
        List<String> patterns = new ArrayList<String>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");
        patterns.add("/districts/**");
        // 通过注册工具添加拦截器
        registry.addInterceptor(loginInterCeptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
