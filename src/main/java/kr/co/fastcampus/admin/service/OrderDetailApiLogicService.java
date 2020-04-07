package kr.co.fastcampus.admin.service;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.OrderDetail;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.OrderDetailApiRequest;
import kr.co.fastcampus.admin.model.network.response.OrderDetailApiResponse;
import kr.co.fastcampus.admin.repository.ItemRepository;
import kr.co.fastcampus.admin.repository.OrderDetailRepository;
import kr.co.fastcampus.admin.repository.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailApiLogicService implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderGroupRepository orderGroupRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest orderDetailApiRequest = request.getData();
        OrderDetail orderDetail = OrderDetail.builder()
                .status(orderDetailApiRequest.getStatus())
                .arrivalDate(orderDetailApiRequest.getArrivalDate())
                .quantity(orderDetailApiRequest.getQuantity())
                .totalPrice(orderDetailApiRequest.getTotalPrice())
                .orderGroup(orderGroupRepository.getOne(orderDetailApiRequest.getOrderGroupId()))
                .item(itemRepository.getOne(orderDetailApiRequest.getItemId()))
                .build();

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        return response(newOrderDetail);
    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        return orderDetailRepository.findById(id)
                .map(orderDetail -> response(orderDetail))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest orderDetailApiRequest = request.getData();

        return orderDetailRepository.findById(orderDetailApiRequest.getId())
                .map(orderDetail -> {
                    orderDetail.setStatus(orderDetailApiRequest.getStatus())
                            .setArrivalDate(orderDetailApiRequest.getArrivalDate())
                            .setQuantity(orderDetailApiRequest.getQuantity())
                            .setTotalPrice(orderDetailApiRequest.getTotalPrice());

                    return orderDetail;
                })
                .map(orderDetail -> orderDetailRepository.save(orderDetail))
                .map(updateOrderDetail -> response(updateOrderDetail))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return orderDetailRepository.findById(id)
                .map(orderDetail -> {
                    orderDetailRepository.delete(orderDetail);
                    return Header.OK();
                })
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    private Header<OrderDetailApiResponse> response(OrderDetail orderDetail) {
        OrderDetailApiResponse orderDetailApiResponse = OrderDetailApiResponse.builder()
                .id(orderDetail.getId())
                .status(orderDetail.getStatus())
                .arrivalDate(orderDetail.getArrivalDate())
                .quantity(orderDetail.getQuantity())
                .totalPrice(orderDetail.getTotalPrice())
                .orderGroupId(orderDetail.getOrderGroup().getId())
                .itemId(orderDetail.getItem().getId())
                .build();

        return Header.OK(orderDetailApiResponse);
    }

}
