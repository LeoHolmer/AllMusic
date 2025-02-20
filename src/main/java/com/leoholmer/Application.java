package com.leoholmer;

import com.leoholmer.AllMusic.Backend.util.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }
}