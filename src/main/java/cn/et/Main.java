package cn.et;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//要让注册中心发现
@EnableEurekaClient
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);		
	}

}
