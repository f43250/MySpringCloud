package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope		//加了此注解客户端执行/refresh的时候就会更新此类下面变量的值,包括通过config client从Git获取配置
public class ConfigClientApplication {

	@Value("${foo}")
	String foo;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}
}
