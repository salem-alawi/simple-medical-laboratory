package com.github.salemalawi.medicallaboratory.model;


import com.github.salemalawi.medicallaboratory.model.enums.RoleEnum;
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
@Document(value = "users")
public class User {


    @Id
    private String  id;

    @Field(name = "name")
    private String name;

    @Field(name = "user_name")
    private String userName;

    @Field(name = "password")
    private String password;

    @Field(name = "disable")
    private Boolean disable;

    @Field(name = "role")
    private RoleEnum role;

}

