package tech.hiyinyougen.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import tech.hiyinyougen.java.aopDemo.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaApplicationTests {

	@Autowired
	private Book2 book2;

	@Test
	public void contextLoads() {
	}

	@Test
	public void aopTest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:aop.xml");
		Book book = (Book)context.getBean("book");
		book.add();
	}

	@Test
	public void aopTest2() {
		book2.add();
	}

	@Test
	public void aopTest3() {
		((IBook)new DynamicProxy().getProxyObject(new Book())).add();
	}

	@Test
	public void aopTest4() {
		((Book)new DynamicProxy2().getProxyObject(new Book())).add();
	}

}
