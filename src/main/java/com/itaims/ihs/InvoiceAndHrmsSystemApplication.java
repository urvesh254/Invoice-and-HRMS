package com.itaims.ihs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class InvoiceAndHrmsSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceAndHrmsSystemApplication.class, args);
	}

}
