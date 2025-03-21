package com.example.SpringJDBCDemo;

import com.example.SpringJDBCDemo.model.Alien;
import com.example.SpringJDBCDemo.repo.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Alien alien=context.getBean(Alien.class);
		alien.setId(11);
		alien.setName("Rohit");
		alien.setTech("Java");

		AlienRepository alienRepository=context.getBean(AlienRepository.class);
		alienRepository.save(alien);
		System.out.println(alienRepository.findAll());
	}

}
