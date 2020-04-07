package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.AdminApplicationTests;
import kr.co.fastcampus.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void create() {
        String account = "phg506";
        String password = "1234";
        String status = "REGISTERED";
        String email = "phg0644@gmail.com";
        String phoneNumber = "010-1111-1112";
        LocalDateTime registeredAt = LocalDateTime.now();

        User user = new User();

        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User newUser = userRepository.save(user);

        assertNotNull(newUser);
        assertEquals(newUser.getAccount(), account);
    }

    @Test
    @Transactional
    public void read() {
        String account = "phg0644";

        User user = userRepository.findAllByAccount(account);

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("------------------주문묶음------------------");
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("총수량 : " + orderGroup.getTotalQuantity());

            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println("------------------주문상세------------------");
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("상품 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getType());
                System.out.println("고객센터 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일 : " + orderDetail.getArrivalDate());


            });
        });


    }
}