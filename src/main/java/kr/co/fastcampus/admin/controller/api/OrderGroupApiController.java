package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.controller.CrudController;
import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.OrderGroup;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.OrderGroupApiRequest;
import kr.co.fastcampus.admin.model.network.response.OrderGroupApiResponse;
import kr.co.fastcampus.admin.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/order_group")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
