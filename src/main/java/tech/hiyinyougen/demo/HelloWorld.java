package tech.hiyinyougen.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yinyg
 * @date 2019/4/22
 */
public class HelloWorld {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(2, "hello2"));
        list.add(new User(1, "hello1"));
        list.add(new User(3, "hello3"));
        System.out.println("原始list: " + list);
        Collections.sort(list);
        System.out.println("实现Comparable来实现排序: " + list);
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User arg1, User arg2) {
                if (arg1 == null || arg2 == null) {
                    throw new NullPointerException();
                }
                if (arg1.getId() == arg2.getId()) {
                    return 0;
                }
                return arg1.getId() < arg2.getId() ? 1 : -1;
            }
        });
        System.out.println("根据Collections.sort重载方法来实现排序: " + list);
    }
}
