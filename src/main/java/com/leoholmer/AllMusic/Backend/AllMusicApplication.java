package com.leoholmer.AllMusic.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.leoholmer"})
public class AllMusicApplication {
	public static void main(String[] args) {
		SpringApplication.run(AllMusicApplication.class, args);


	}

}
