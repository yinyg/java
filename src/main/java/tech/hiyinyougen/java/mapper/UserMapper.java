package tech.hiyinyougen.java.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.hiyinyougen.java.domain.User;

import java.util.List;

/**
 * @author yinyg
 * @date 2019/6/26
 */
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    List<User> findAllXml();
}
