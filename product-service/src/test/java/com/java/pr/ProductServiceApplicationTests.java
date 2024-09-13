package com.java.pr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {

	/*@Container
	static  MySQLContainer mySQLContainer=new MySQLContainer();*/
	@Test
	void contextLoads() {
	}

}
