
package org.scijava.ops;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class SciJavaOpsApplication implements CommandLineRunner {

	private static ApplicationContext applicationContext;

	@Autowired
	private Supplier<Thing> appName;

	@Bean
	public Supplier<Thing> getThing() {
		return () -> new Thing();
	}

	@Bean
	@Primary
	public Supplier<Thing> getNumberThing() {
		return () -> new NumberThing();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Application name blahity blah: " + appName);
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SciJavaOpsApplication.class,
			args);
	}

}

class Thing {

}

class NumberThing extends Thing {
	
}
