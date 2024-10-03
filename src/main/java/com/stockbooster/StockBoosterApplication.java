package com.stockbooster;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@OpenAPIDefinition(
        info = @Info(
                title = "StockBooster",
                description = "an E-commerce platform API Documentation.",
                version = "2024.09",
                contact = @Contact(
                        name = "Hushtar·Ezmat",
                        email = "@Hushtar.Ez@gmail.com",
                        url = "https://github.com/Hushtarr"
                )
        ))
public class StockBoosterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockBoosterApplication.class, args);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}

