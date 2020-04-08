package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.model.entity.Item;
import kr.co.fastcampus.admin.model.enumclass.ItemStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest extends AdminUserRepositoryTest{

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void create() {
        ItemStatus status = ItemStatus.REGISTERED;
        String name = "삼성 노트북";
        String title = "삼성 노트북 A100";
        String content = "2019년형 노트북 입니다.";
        BigDecimal price = new BigDecimal("900000");
        String brandName = "삼성";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Partner01";
         Long partnerId = 1L;

        Item item = new Item();

        item.setStatus(status);
        item.setName(name);
        item.setTitle(title);
        item.setContent(content);
        item.setPrice(price);
        item.setBrandName(brandName);
        item.setRegisteredAt(registeredAt);
        item.setCreatedAt(createdAt);
        item.setCreatedBy(createdBy);
//        item.setPartnerId(partnerId);

        Item newItem = itemRepository.save(item);

        assertNotNull(newItem);
        assertEquals(newItem.getContent(), content);
    }

}