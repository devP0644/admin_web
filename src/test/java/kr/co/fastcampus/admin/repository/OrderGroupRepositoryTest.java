package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.model.entity.OrderGroup;
import kr.co.fastcampus.admin.model.enumclass.OrderStatus;
import kr.co.fastcampus.admin.model.enumclass.OrderType;
import kr.co.fastcampus.admin.model.enumclass.PaymentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderGroupRepositoryTest extends  AdminUserRepositoryTest{

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Test
    public void create() {
        OrderGroup orderGroup = new OrderGroup();

        orderGroup.setStatus(OrderStatus.COMPLETE);
        orderGroup.setOrderType(OrderType.ALL);
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType(PaymentType.CARD);
        orderGroup.setTotalPrice(new BigDecimal(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        assertNotNull(newOrderGroup);
    }
}