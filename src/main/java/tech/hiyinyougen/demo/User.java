package tech.hiyinyougen.demo;

import lombok.*;

import java.util.Objects;

/**
 * @Author yinyg
 * @CreateTime 2020/4/2 16:52
 * @Description
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable {
    private int id;

    private String name;

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if (user == null) {
            throw new NullPointerException();
        }
        if (this.getId() == user.getId()) {
            return 0;
        }
        return this.getId() > user.getId() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
