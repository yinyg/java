package tech.hiyinyougen.java.aopDemo;

import org.springframework.stereotype.Service;

/**
 * @Author yinyg
 * @CreateTime 2019/10/30 11:08
 * @Description
 */
@Service("book2")
public class Book2 {

    public void add() {
        System.out.println("add...注解版本...");
    }

}
