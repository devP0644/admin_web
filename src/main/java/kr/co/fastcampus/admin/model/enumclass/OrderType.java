package kr.co.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderType {
    ALL(0, "전체", "일괄 배송"),
    EACH(1, "개별", "개별 배송");

    private Integer id;
    private String title;
    private String description;
}
