package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.controller.CrudController;
import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.Partner;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.PartnerApiRequest;
import kr.co.fastcampus.admin.model.network.response.PartnerApiResponse;
import kr.co.fastcampus.admin.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {


}
