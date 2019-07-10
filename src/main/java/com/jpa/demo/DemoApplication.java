package com.jpa.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd(EntityManager manager) {
		return args -> {
			System.out.println("Hello, World!");
		};
	}
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
}

@Table(name = "orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Order {
	@Id
	@GeneratedValue
	private Long id;
	private String sku;
	@JoinColumn(name = "CUSTOMER_ID")
	@ManyToOne
	private Customer customer;
}
