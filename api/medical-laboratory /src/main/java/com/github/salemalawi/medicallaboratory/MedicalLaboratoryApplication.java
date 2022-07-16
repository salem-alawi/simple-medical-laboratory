package com.github.salemalawi.medicallaboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;

@EnableReactiveMethodSecurity
@SpringBootApplication
public class MedicalLaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalLaboratoryApplication.class, args);
	}

}
