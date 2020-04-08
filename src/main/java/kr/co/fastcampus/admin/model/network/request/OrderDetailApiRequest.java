package kr.co.fastcampus.admin.model.network.request;

import kr.co.fastcampus.admin.model.enumclass.OrderStatus;
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
public class OrderDetailApiRequest {
    private Long id;

    private OrderStatus status;

    private LocalDateTime arrivalDate;

    private BigDecimal quantity;

    private BigDecimal totalPrice;

    private Long orderGroupId;

    private Long itemId;
}
