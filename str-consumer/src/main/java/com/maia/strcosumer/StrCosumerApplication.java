package com.maia.strcosumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka
@SpringBootApplication
public class StrCosumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrCosumerApplication.class, args);
	}

}
