package com.imooc.girl.core.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hmh on 2017/7/31.
 */
@Component
@ConfigurationProperties(prefix = "girl")
@Data
public class GirlProperties {
    private String cupSize;

    private Integer age;
}
