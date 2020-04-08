package kr.co.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemStatus {
    REGISTERED(0, "등록", "사용자 등록상태"),
    UNREGISTERED(1, "해지", "사용자 해지상태"),
    WAITING(2, "검수(대기)", "상품 검수상태");

    private Integer id;
    private String title;
    private String description;


}
