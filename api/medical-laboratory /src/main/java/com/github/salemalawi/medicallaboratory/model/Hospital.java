package com.github.salemalawi.medicallaboratory.model;

import com.github.salemalawi.medicallaboratory.model.modelDto.ContactUs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(value = "hospital")
public class Hospital {

    @Id
    private String id;

    private String name;

    private String iconImage;

    private ContactUs contactUs;

    private String title;

}

