package com.ex;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ex.*")
@EnableAutoConfiguration
public class AppMain {
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(AppMain.class, args);
    }
    
    @PostConstruct
    public void postConstruct(){
  		System.out.println("This is AppMain --> postConstruct()");
    }
}
