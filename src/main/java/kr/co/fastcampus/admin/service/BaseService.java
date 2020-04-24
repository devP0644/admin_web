package kr.co.fastcampus.admin.service;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.User;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.response.UserApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.sound.midi.SoundbankResource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class BaseService<req, res, Entity> implements CrudInterface<req, res> {

    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;

    @Override
    public Header<List<res>> search(Pageable pageable) {
        Page<Entity> entitys = baseRepository.findAll(pageable);

        List<res> entityApiResponseList = entitys.stream()
                .map(entity -> this.response(entity))
                .collect(Collectors.toList());

        return Header.OK(entityApiResponseList);
    }

    public abstract res response(Entity entity);
}
