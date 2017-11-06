package com.imooc.girl.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;

/**
 * Created by hmh on 2017/8/31.
 */
@Log4j
@Getter
@AllArgsConstructor
public enum FileTypeEnum {

    JPEG("FFD8FF"),
    PNG("89504E47"),
    GIF("47494638"),
    TIFF("49492A00"),
    BMP("424D"),
    DWG("41433130"),
    PSD("38425053"),
    XML("3C3F786D6C"),
    HTML("68746D6C3E"),
    PDF("255044462D312E"),
    ZIP("504B0304"),
    RAR("52617221"),
    WAV("57415645"),
    AVI("41564920")
    ;

    private String value;
}
