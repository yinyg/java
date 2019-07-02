package tech.hiyinyougen.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yinyg
 * @date 2019/6/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {
    private Long id;

    // 用户名
    private String username;

    // 手机
    private String phone;
}
