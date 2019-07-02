package tech.hiyinyougen.java.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.hiyinyougen.java.domain.User;

/**
 * @author yinyg
 * @date 2019/6/18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {
    @Query("select u from #{#entityName} u where u.username like %:username%")
    Page<User> findAllByQuery(@Param("username") String username, Pageable pageable);
}
