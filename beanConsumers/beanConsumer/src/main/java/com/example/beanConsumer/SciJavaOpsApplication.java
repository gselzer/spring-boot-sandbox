
package com.example.beanConsumer;

import com.example.beanProducer.IndependentBeanThing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class SciJavaOpsApplication implements CommandLineRunner {

	private static ApplicationContext applicationContext;

	@Override
	public void run(String... args) throws Exception {

	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SciJavaOpsApplication.class,
			args);
		IndependentBeanThing thing = applicationContext.getBean(IndependentBeanThing.class);
	}

}
