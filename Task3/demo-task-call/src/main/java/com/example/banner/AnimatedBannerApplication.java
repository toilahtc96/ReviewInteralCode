package com.example.banner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
		"com.example.banner"})
@EnableJpaRepositories("com.example.banner")
public class AnimatedBannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimatedBannerApplication.class, args);
	}
}
