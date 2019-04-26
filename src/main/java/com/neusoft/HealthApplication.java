package com.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.neusoft.dao")
@EnableAsync   // 线程池注解
@EnableTransactionManagement
@EnableCaching
public class HealthApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class, args);
        System.out.println("======================================================================\n" +
                "\n" +
                "    欢迎使用   - Created By xiaoyc\n" +
                "\n" +
                "======================================================================");
    }
//     继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HealthApplication.class);
	}

}
