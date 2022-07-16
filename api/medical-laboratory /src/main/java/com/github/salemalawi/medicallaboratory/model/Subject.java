package com.github.salemalawi.medicallaboratory.model;


import com.github.salemalawi.medicallaboratory.model.enums.InputTypeEnum;
import com.github.salemalawi.medicallaboratory.model.modelDto.InputTypeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(value = "subjects")
public class Subject {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "input_type")
    private InputTypeDto inputOption;

    @Field(name = "category")
    private Category category;

    @Field(name = "cost")
    private Long cost;

    @Field(name = "note")
    private String note;





}
