package com.imooc.girl.core.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Girl {
    private Integer id;

    private Integer age;

    private String cupSize;

    private Float money;
}