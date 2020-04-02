package tech.hiyinyougen.java.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import tech.hiyinyougen.java.domain.User;
import tech.hiyinyougen.java.dto.UserSaveDTO;
import tech.hiyinyougen.java.mapper.UserMapper;
import tech.hiyinyougen.java.repository.UserRepository;

import java.util.List;

/**
 * @author yinyg
 * @date 2019/6/18
 */
@Api(value = "UserController", description = "用户相关")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("查询所有用户")
    @GetMapping("/findAll")
    public Page<User> findAll(String username, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return userRepository.findAllByQuery("yyg", pageable);
    }

    @ApiOperation("查询所有用户-mybatis")
    @GetMapping("/findAllByMybatis")
    public List<User> findAllByMybatis() {
        return userMapper.findAll();
    }

    @ApiOperation("查询所有用户-mybatisxml")
    @GetMapping("/findAllByMybatisxml")
    public List<User> findAllByMybatisXml() {
        return userMapper.findAllXml();
    }

    @ApiOperation("新增所有用户")
    @PostMapping("/save")
    public boolean save(@RequestBody UserSaveDTO dto) {
        try {
            User user = User.builder()
                    .id(dto.getId())
                    .username(dto.getUsername())
                    .phone(dto.getPhone())
                    .build();
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") User user) {
        return user;
    }
}
