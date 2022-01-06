package com.djh.configuration;

import com.djh.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc配置
 * @author MyMrDiao
 * @date 2020/08/09
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 重写接口中的addInterceptors方法，添加自定义拦截器
     * @param registry 注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /** 添加拦截器，通过addPathPatterns来添加拦截路径 */
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**");
    }
}
