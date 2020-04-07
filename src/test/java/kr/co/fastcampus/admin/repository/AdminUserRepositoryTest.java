package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.AdminApplicationTests;
import kr.co.fastcampus.admin.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserRepositoryTest extends AdminApplicationTests {
    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create() {

        AdminUser adminUser = AdminUser.builder()
                .account("Admin03")
                .password("12345")
                .status("REGISTERED")
                .role("PARTNER")
                .build();

        Optional<AdminUser> checkAdminUser = adminUserRepository.findByAccount("Admin03");

        if(checkAdminUser == null) {
            AdminUser newAdminUser = adminUserRepository.save(adminUser);
            assertNotNull(newAdminUser);
        }else {
            System.out.println("이미 존재하는 아이디입니다.");
        }

    }
}