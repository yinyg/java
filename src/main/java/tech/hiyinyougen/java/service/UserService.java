package tech.hiyinyougen.java.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.hiyinyougen.java.dao.UserDao;
import tech.hiyinyougen.java.domain.User;
import tech.hiyinyougen.java.model.UserModel;
import tech.hiyinyougen.java.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 15:02
 * @Description
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Lazy
    private EntityManager entityManager;

    @Transactional
    public boolean save(UserModel userModel) {
//        try {
//            Thread.sleep(1000L * 10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int result = userDao.save(userModel);
//        if (userModel.getUsername().substring(0, 8).equals("zhangsan")) {
//            throw new RuntimeException("事务测试");
//        }
//        if (result == 1) {
//            return true;
//        }
//        return false;

        Session session = entityManager.unwrap(org.hibernate.Session.class);
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            userList.add(User.builder()
                    .age(userModel.getAge())
                    .Username(userModel.getUsername())
                    .build());
        }
        userRepository.saveAll(userList);
        session.clear();
        try {
            Thread.sleep(1000L * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
