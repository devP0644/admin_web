package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin.model.network.response.AdminUserApiResponse;
import kr.co.fastcampus.admin.service.AdminUserApiLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin_user")
public class AdminUserApiController implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    AdminUserApiLoginService adminUserApiLoginService;

    @Override
    @PostMapping("")
    public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLoginService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<AdminUserApiResponse> read(@PathVariable Long id) {
        return adminUserApiLoginService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLoginService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<AdminUserApiResponse> delete(@PathVariable Long id) {
        return adminUserApiLoginService.delete(id);
    }
}
