package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.UserApiRequest;
import kr.co.fastcampus.admin.model.network.response.UserApiResponse;
import kr.co.fastcampus.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);

        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable Long id) {
        log.info("read id : {}", id);

        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);

        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("read id : {}", id);

        return userApiLogicService.delete(id);
    }
}