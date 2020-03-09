package com.praveen.cms.api.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderPlacedResponse {

    private Long orderId;
    private String message ="Your order is successfully placed";

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
