package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.model.entity.OrderDetail;
import kr.co.fastcampus.admin.model.enumclass.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailRepositoryTest extends AdminUserRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus(OrderStatus.WAITING);
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(new BigDecimal(1));
        orderDetail.setTotalPrice(new BigDecimal(900000));
//        orderDetail.setOrderGroupId(1L);
//        orderDetail.setItemId(1L);
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        assertNotNull(newOrderDetail);

    }
}