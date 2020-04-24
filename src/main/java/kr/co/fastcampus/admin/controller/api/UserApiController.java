package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.controller.CrudController;
import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.User;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.UserApiRequest;
import kr.co.fastcampus.admin.model.network.response.UserApiResponse;
import kr.co.fastcampus.admin.model.network.response.UserOderInfoApiReponse;
import kr.co.fastcampus.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {
    @Autowired
    UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/order_info")
    public Header<UserOderInfoApiReponse> orderInfo(@PathVariable Long id) {
        return userApiLogicService.orderInfo(id);
    }
}
