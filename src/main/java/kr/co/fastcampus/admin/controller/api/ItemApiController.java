package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.controller.CrudController;
import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.Item;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.ItemApiRequest;
import kr.co.fastcampus.admin.model.network.response.ItemApiResponse;
import kr.co.fastcampus.admin.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
