package com.mearsk.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotion {
    private Integer promotionId;
    private Integer promotionPrice;
    private Integer promotionAvailableNumber;
    private Integer productId;

}
