
package org.scijava.ops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SciJavaOpsApplication implements CommandLineRunner {

	private static ApplicationContext applicationContext;

	@Autowired
	private AppName appName;

	@Bean
	public AppName getAppName(@Value("${app.name}") String appName) {

		return () -> appName;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Application name blahity blah: " + appName.getName());
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SciJavaOpsApplication.class, args);
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		AppName a = applicationContext.getBean(AppName.class);
		System.out.println(a.getName());
	}

}
