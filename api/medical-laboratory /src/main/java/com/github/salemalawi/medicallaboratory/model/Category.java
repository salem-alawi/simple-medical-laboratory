package com.github.salemalawi.medicallaboratory.model;


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
@Document(value = "categories")
public class Category {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "image")
    private String image;

    @Field(name = "note")
    private String note;

    @Field(name = "subjects")
    private List<Subject> subjectList;

}
