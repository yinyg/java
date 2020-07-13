package tech.hiyinyougen.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.hiyinyougen.java.dao.UserDao;
import tech.hiyinyougen.java.model.ResultModel;
import tech.hiyinyougen.java.model.UserModel;
import tech.hiyinyougen.java.service.UserService;

import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 10:26
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResultModel findAll() {
        List<UserModel> userModelList = userDao.selectAll();
        return ResultModel.builder().success(Boolean.TRUE).data(userModelList).build();
    }

    @PostMapping("save")
    public ResultModel save(@RequestBody UserModel userModel) {
        this.userService.save(userModel);
        return ResultModel.builder().success(Boolean.TRUE).build();
    }
}
