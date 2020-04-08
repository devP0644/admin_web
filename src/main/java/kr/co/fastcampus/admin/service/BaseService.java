package kr.co.fastcampus.admin.service;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseService<req, res, Entity> implements CrudInterface<req, res> {

    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;
}
