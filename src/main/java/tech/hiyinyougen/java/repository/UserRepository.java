package tech.hiyinyougen.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hiyinyougen.java.domain.User;

/**
 * @author yinyg
 * @date 2020/8/7
 * @description
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
