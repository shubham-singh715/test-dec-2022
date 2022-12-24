package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DemoApplicationTests {

	@Container
	public static MySQLContainer container=new MySQLContainer("mysql:latest")
			.withDatabaseName("abc")
			.withPassword("foo")
			.withUsername("bar");

	@Test
	void demoTest() {
		assertThat(container.isRunning()).isTrue();

	}

}
