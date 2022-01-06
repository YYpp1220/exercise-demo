package com.djh.spirngjdbc;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 高的应用程序
 *
 * @author MyMrDiao
 * @date 2020/08/09
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.djh.spirngjdbc.mapper"})
public class HighApplication {
    public static void main(String[] args) {
        SpringApplication.run(HighApplication.class, args);
    }
}
