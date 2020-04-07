package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.CategoryApiRequest;
import kr.co.fastcampus.admin.model.network.response.CategoryApiResponse;
import kr.co.fastcampus.admin.service.CategoryApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    CategoryApiLogicService categoryApiLogicService;

    @Override
    @PostMapping("")
    public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request) {
        return categoryApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<CategoryApiResponse> read(@PathVariable Long id) {
        return categoryApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request) {
        return categoryApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return categoryApiLogicService.delete(id);
    }
}