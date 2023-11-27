package com.muratArslan.postgresqlrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
public class PostgresqlRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlRestApiApplication.class, args);
	}

}
