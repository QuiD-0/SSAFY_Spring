package com.ssafy.happyhouse.config;

import com.ssafy.happyhouse.interceptor.ConfirmInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.ssafy.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ConfirmInterceptor confirm;

    private final List<String> patterns = Arrays.asList("/user/*", "/notice/*", "/comment/*");
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(confirm).addPathPatterns(patterns);
    }
}
