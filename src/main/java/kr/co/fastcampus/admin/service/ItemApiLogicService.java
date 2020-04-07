package kr.co.fastcampus.admin.service;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.Item;
import kr.co.fastcampus.admin.model.entity.User;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.ItemApiRequest;
import kr.co.fastcampus.admin.model.network.response.ItemApiResponse;
import kr.co.fastcampus.admin.model.network.response.UserApiResponse;
import kr.co.fastcampus.admin.repository.ItemRepository;
import kr.co.fastcampus.admin.repository.PartnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

        ItemApiRequest itemApiRequest = request.getData();

        Item item = Item.builder()
                .status(itemApiRequest.getStatus())
                .name(itemApiRequest.getName())
                .title(itemApiRequest.getTitle())
                .content(itemApiRequest.getContent())
                .price(itemApiRequest.getPrice())
                .brandName(itemApiRequest.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(itemApiRequest.getPartnerId()))
                .build();

        Item newItem = itemRepository.save(item);

        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        return itemRepository.findById(id)
                .map(item -> response(item))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {

            ItemApiRequest itemApiRequest = request.getData();

                return itemRepository.findById(itemApiRequest.getId())
                    .map(item -> {
                        item.setStatus(itemApiRequest.getStatus())
                                .setName(itemApiRequest.getName())
                                .setTitle(itemApiRequest.getTitle())
                                .setContent(itemApiRequest.getContent())
                                .setPrice(itemApiRequest.getPrice())
                                .setBrandName(itemApiRequest.getBrandName())
                                .setRegisteredAt(itemApiRequest.getRegisteredAt())
                                .setUnregisteredAt(itemApiRequest.getUnregisteredAt());
                        return item;
                    })
                    .map(item -> itemRepository.save(item))
                    .map(updateItem->response(updateItem))
                    .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        return itemRepository.findById(id)
                .map(item -> {
                    itemRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<ItemApiResponse> response(Item item) {
        ItemApiResponse itemApiResponse = ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();

        return Header.OK(itemApiResponse);
    }
}
