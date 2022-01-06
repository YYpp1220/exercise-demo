package com.djh.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author MyMrDiao
 * @date 2020/08/09
 */
@Configuration
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 前处理
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @return boolean* @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("== preHandle 方法执行! ==");
        return true;
    }

    /**
     * 处理后
     * @param request      请求
     * @param response     响应
     * @param handler      处理程序
     * @param modelAndView 模型和视图
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("== postHandle 方法执行! ==");
    }

    /**
     * 完成后
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @param ex       前女友
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("== afterCompletion 方法执行! ==");
    }
}
