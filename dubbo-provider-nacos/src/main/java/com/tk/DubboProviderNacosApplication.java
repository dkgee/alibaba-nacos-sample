package com.tk;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@EnableDubbo(scanBasePackages = "com.tk.service")
@PropertySource(value = "classpath:/dubbo-config.properties")
@SpringBootApplication
public class DubboProviderNacosApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DubboProviderNacosApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(DubboProviderNacosApplication.class);
//		context.refresh();
//		System.out.println("DemoService provider starting...");
		System.in.read();
	}

}

