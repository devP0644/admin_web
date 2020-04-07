package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.AdminApplicationTests;
import kr.co.fastcampus.admin.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest extends AdminApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "TOY";
        String title = "로봇";
        LocalDateTime createdAt = LocalDateTime.now();
        String createBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createBy);

        Category newCategory = categoryRepository.save(category);

        assertNotNull(newCategory);
        assertEquals(newCategory.getType(), type);
        assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read() {
        String type = "COMPUTER";

        Optional<Category> category = categoryRepository.findByType(type);

        category.ifPresent(selectCategory->{
            assertEquals(selectCategory.getType(), type);
        });
    }
}