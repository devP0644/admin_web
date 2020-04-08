package kr.co.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    PAYMENT_WAITING(0, "결제대기", "결제대기상태"),
    PAYMENT_FINISHED(1, "결제완료", "결제완료상태"),
    WAITING(2, "배송대기중", "배송대기상태"),
    COMPLETE(3, "배송완료", "배송완료상태");

    private Integer id;
    private String title;
    private String description;


}
