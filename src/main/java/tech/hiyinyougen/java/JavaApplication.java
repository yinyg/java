package tech.hiyinyougen.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tech.hiyinyougen.java.dto.UserSaveDTO;

@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:test.xml");
		UserSaveDTO user = (UserSaveDTO)context.getBean("user");
		System.out.println(user);

		SpringApplication.run(JavaApplication.class, args);
	}

}
