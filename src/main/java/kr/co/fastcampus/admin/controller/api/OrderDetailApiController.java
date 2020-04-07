package kr.co.fastcampus.admin.controller.api;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.OrderDetailApiRequest;
import kr.co.fastcampus.admin.model.network.response.OrderDetailApiResponse;
import kr.co.fastcampus.admin.service.OrderDetailApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order_detail")
public class OrderDetailApiController implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private OrderDetailApiLogicService orderDetailApiLogicService;


    @Override
    @PostMapping("")
    public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request) {
        return orderDetailApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderDetailApiResponse> read(@PathVariable Long id) {
        return orderDetailApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request) {
        return orderDetailApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return orderDetailApiLogicService.delete(id);
    }
}