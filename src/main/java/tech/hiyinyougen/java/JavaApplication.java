package tech.hiyinyougen.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("tech.hiyinyougen.java.dao")
public class JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}
