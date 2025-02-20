package com.leoholmer.AllMusic.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.leoholmer.AllMusic", "com.leoholmer.AllMusic.Backend.util"})
public class AllMusicApplication {
	public static void main(String[] args) {
		SpringApplication.run(AllMusicApplication.class, args);
	}
}