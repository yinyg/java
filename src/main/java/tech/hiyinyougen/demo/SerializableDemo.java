package tech.hiyinyougen.demo;

import lombok.Builder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2019/8/7 15:41
 * @Description
 */
public class SerializableDemo {

    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/yinyougen/projects/demo/java/src/main/resources/static/serializable.txt"))) {

            List<User> list = new ArrayList<>();
            list.add(new User("yyg"));
            list.add(new User("yyg2"));

            objectOutputStream.writeObject(list);

        } catch (Exception e) {
            e.printStackTrace();
        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/yinyougen/projects/demo/java/src/main/resources/static/serializable.txt"))) {

            List<User> users = (List<User>) objectInputStream.readObject();

            for (User u : users) {
                System.out.println(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class User implements Serializable {

    private String username;

    @Builder.Default
    private String password = "123";

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
