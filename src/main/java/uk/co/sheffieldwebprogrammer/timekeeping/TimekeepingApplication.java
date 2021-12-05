package uk.co.sheffieldwebprogrammer.timekeeping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TimekeepingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimekeepingApplication.class, args);
	}

}
