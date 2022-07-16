package com.github.salemalawi.medicallaboratory.model.modelDto;

import com.github.salemalawi.medicallaboratory.model.enums.InputTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InputTypeDto {

    private InputTypeEnum inputType;
    private String defaultValue;
    private List<String> values;
    private String normalValueRegx;
    private String badValueRegx;
    private String warningValueRegx;

}
