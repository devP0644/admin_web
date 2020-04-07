package kr.co.fastcampus.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailApiResponse {
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private BigDecimal quantity;

    private BigDecimal totalPrice;

    private Long orderGroupId;

    private Long itemId;
}
