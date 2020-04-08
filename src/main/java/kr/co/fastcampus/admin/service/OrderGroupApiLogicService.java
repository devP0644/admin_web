package kr.co.fastcampus.admin.service;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.OrderGroup;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.OrderGroupApiRequest;
import kr.co.fastcampus.admin.model.network.response.OrderGroupApiResponse;
import kr.co.fastcampus.admin.repository.OrderGroupRepository;
import kr.co.fastcampus.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest orderApiGroupRequest = request.getData();

        OrderGroup orderGroup = OrderGroup.builder()
                .status(orderApiGroupRequest.getStatus())
                .orderType(orderApiGroupRequest.getOrderType())
                .revAddress(orderApiGroupRequest.getRevAddress())
                .revName(orderApiGroupRequest.getRevName())
                .paymentType(orderApiGroupRequest.getPaymentType())
                .totalPrice(orderApiGroupRequest.getTotalPrice())
                .totalQuantity(orderApiGroupRequest.getTotalQuantity())
                .orderAt(orderApiGroupRequest.getOrderAt())
                .arrivalDate(orderApiGroupRequest.getArrivalDate())
                .user(userRepository.getOne(orderApiGroupRequest.getUserId()))
                .build();

        OrderGroup newOrderGroup = baseRepository.save(orderGroup);

        return Header.OK(response(newOrderGroup));
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(orderGroup -> response(orderGroup))
                .map(Header::OK)
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {

        OrderGroupApiRequest orderGroupApiRequest = request.getData();

        return baseRepository.findById(orderGroupApiRequest.getId())
                .map(orderGroup -> {
                    orderGroup.setStatus(orderGroupApiRequest.getStatus())
                            .setOrderType(orderGroupApiRequest.getOrderType())
                            .setRevAddress(orderGroupApiRequest.getRevAddress())
                            .setRevName(orderGroupApiRequest.getRevName())
                            .setPaymentType(orderGroupApiRequest.getPaymentType())
                            .setTotalPrice(orderGroupApiRequest.getTotalPrice())
                            .setTotalQuantity(orderGroupApiRequest.getTotalQuantity())
                            .setOrderAt(orderGroupApiRequest.getOrderAt())
                            .setArrivalDate(orderGroupApiRequest.getArrivalDate());
                    return orderGroup;
                })
                .map(orderGroup -> baseRepository.save(orderGroup))
                .map(orderGroup -> response(orderGroup))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        Optional<OrderGroup> optional = baseRepository.findById(id);

        return optional
                .map(orderGroup -> {
                    baseRepository.delete(orderGroup);
                    return Header.OK();
                })
                .orElseGet(()-> Header.ERROR("데이터 없음"));

    }

    public OrderGroupApiResponse response(OrderGroup orderGroup) {
        OrderGroupApiResponse orderGroupApiResponse = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getId())
                .build();

        return orderGroupApiResponse;
    }
}
