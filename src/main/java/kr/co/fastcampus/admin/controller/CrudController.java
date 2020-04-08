package kr.co.fastcampus.admin.controller;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public abstract class CrudController<req, res, Entity> implements CrudInterface<req, res> {

    @Autowired(required = false)
    protected BaseService<req, res, Entity> baseService;

    @Override
    @PostMapping("")
    public Header<res> create(@RequestBody Header<req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<res> read(@PathVariable Long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<res> update(@RequestBody Header<req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return baseService.delete(id);
    }
}
