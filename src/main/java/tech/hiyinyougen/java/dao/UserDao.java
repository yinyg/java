package tech.hiyinyougen.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.hiyinyougen.java.model.UserModel;

import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 10:20
 * @Description
 */
@Mapper
public interface UserDao {
    @Select("select * from user")
    List<UserModel> selectAll();

    List<UserModel> selectAllXML();

    int save(UserModel userModel);
}
