package tech.hiyinyougen.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.hiyinyougen.java.dao.UserDao;
import tech.hiyinyougen.java.model.UserModel;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 15:02
 * @Description
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public boolean save(UserModel userModel) {
//        try {
//            Thread.sleep(1000L * 10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int result = userDao.save(userModel);
        if (userModel.getUsername().substring(0, 8).equals("zhangsan")) {
            throw new RuntimeException("事务测试");
        }
        if (result == 1) {
            return true;
        }
        return false;
    }
}
