package com.tk;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.tk.service.DemoService;
import com.tk.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;

@EnableDubbo
@PropertySource(value = "classpath:/dubbo-config.properties")
@SpringBootApplication
public class DubboConsumerNacosApplication {

	@Reference(version = "${demo.service.version}")
	private DemoService demoService;

	@Reference
	private HelloService helloService;

	@PostConstruct
	public void init() {
		for (int i = 0; i < 10; i++) {
			System.out.println(demoService.sayName("Mercy"));
			System.out.println(helloService.sayHello("tk"));
		}
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DubboConsumerNacosApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(DubboConsumerNacosApplication.class);
//		context.refresh();
//		context.close();
		System.in.read();
	}

}

