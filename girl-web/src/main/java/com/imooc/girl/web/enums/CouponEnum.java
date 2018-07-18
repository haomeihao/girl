package com.imooc.girl.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by hmh on 2017/11/13.
 */
@Getter
@AllArgsConstructor
public enum CouponEnum {

    FIRST(99.0, 5.0),
    SECOND(199.0, 15.0),
    THIRD(399.0, 35.0),
    FOURTH(599.0, 65.0),
    FIFTH(799.0, 100.0);

    private Double amount;
    private Double coupon;
}
