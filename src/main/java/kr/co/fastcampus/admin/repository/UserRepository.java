package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByAccount(String account);
}
