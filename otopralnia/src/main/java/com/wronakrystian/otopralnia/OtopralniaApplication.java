package com.wronakrystian.otopralnia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.wronakrystian.otopralnia.controllers.RunApp;

@SpringBootApplication
@ComponentScan(value= {"com.wronakrystian.otopralnia"} )
public class OtopralniaApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(OtopralniaApplication.class, args);
		RunApp app = (RunApp) context.getBean("runApp");
		app.run();
		
	}
	

}
