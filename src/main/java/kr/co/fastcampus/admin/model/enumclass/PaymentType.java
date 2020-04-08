package kr.co.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentType {
    CARD(0, "카드", "카드로 결제"),
    MONEY(1,"현금", "현금으로 결제"),
    PHONE(2,"휴대폰", "휴대폰 결제"),
    TRANSFER(3,"계좌이체", "계좌이체"),
    GIFT_CARD(4,"상품권", "상품권으로 결제"),
    PAY(5,"페이", "페이로 결제");

    private Integer id;
    private String title;
    private String description;
}
