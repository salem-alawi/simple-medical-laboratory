package com.github.salemalawi.medicallaboratory.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(value = "sections")
public class Section {

    @Id
    private String id;

    @Field(name = "name")
    private String name;



}
