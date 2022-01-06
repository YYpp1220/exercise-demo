package com.djh.spirngjdbc.config;

import com.djh.spirngjdbc.HighApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * web servlet初始化
 *
 * @author MyMrDiao
 * @date 2020/08/21
 */
public class WebServletInitializer extends SpringBootServletInitializer {
    /**
     * 配置
     * @param builder 构建器
     * @return {@link SpringApplicationBuilder}
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 设置启动类
        builder.sources(HighApplication.class);
        // 返回spring应用构建对象
        return builder;
    }
}
