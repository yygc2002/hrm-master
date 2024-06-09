package com.qiujie.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;

@Getter
@AllArgsConstructor
public enum TranscationTypeEnum implements BaseEnum<T>{
    ADD(0,"添加","add"),
    UPDATE(1,"更新","update"),
    DELETE(2,"删除","delete");

    @EnumValue
    private final Integer code;
    @JsonValue
    private final String message;

    private final String tagType;
}
