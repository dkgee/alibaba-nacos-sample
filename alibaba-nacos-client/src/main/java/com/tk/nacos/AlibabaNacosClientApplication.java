package com.tk.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

//@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosClientApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AlibabaNacosClientApplication.class, args);
		System.in.read();
	}

	@Slf4j
	@RestController
	static class TestController{

//		@Value("${nocas.server.name}")
//		String nacosServerName;

//		@Autowired
//		LoadBalancerClient loadBalancerClient;
//
//		@GetMapping("/test")
//		public String test(){
//			ServiceInstance serviceInstance = loadBalancerClient.choose(nacosServerName);
//			String url = serviceInstance.getUri() + "/hello?name=" + "tk";
//			RestTemplate restTemplate = new RestTemplate();
//			String result = restTemplate.getForObject(url, String.class);
//			return "invoke:" + url + ", return: " + result;
//		}

//		@Autowired
//		private WebClient.Builder webClientBuilder;
//
//		@GetMapping("/test")
//		public Mono<String> test(){
//			Mono<String> result = webClientBuilder.build()
//					.get()
//					.uri(nacosServerName)
//					.retrieve()
//					.bodyToMono(String.class);
//			return result;
//		}

	}

//	@Bean
//	@LoadBalanced
//	public WebClient.Builder loadBalancedWebClientBuilder(){
//		return WebClient.builder();
//	}

}

