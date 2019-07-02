package tech.hiyinyougen.java.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author yinyg
 * @date 2019/6/18
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 用户名
    private String username;

    // 手机
    private String phone;
}
