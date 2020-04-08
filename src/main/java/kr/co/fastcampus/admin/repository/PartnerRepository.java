package kr.co.fastcampus.admin.repository;

import kr.co.fastcampus.admin.model.entity.Category;
import kr.co.fastcampus.admin.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByCategory(Category category);
}
