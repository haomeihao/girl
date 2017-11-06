package com.imooc.girl.core.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by hmh on 2017/7/31.
 */
@Entity
@Data
@ToString
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "未成年人禁止入内")
    private Integer age;

    @NotNull(message = "金额必填")
    private Float money;

}
