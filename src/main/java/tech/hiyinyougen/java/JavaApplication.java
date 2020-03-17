package tech.hiyinyougen.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.hiyinyougen.java.domain.User;

@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Bean(initMethod = "initMethod2",destroyMethod = "destroyMethod")
	public User user(){
		return new User();
	}

}
