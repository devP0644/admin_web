package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.controller.CrudController;
import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin.model.network.response.AdminUserApiResponse;
import kr.co.fastcampus.admin.service.AdminUserApiLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/admin_user")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    AdminUserApiLoginService adminUserApiLoginService;

    @PostConstruct
    private void init() {
        this.baseService = adminUserApiLoginService;
    }


}
