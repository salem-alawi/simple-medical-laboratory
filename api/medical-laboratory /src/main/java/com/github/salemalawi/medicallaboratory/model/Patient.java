package com.github.salemalawi.medicallaboratory.model;


import com.github.salemalawi.medicallaboratory.model.enums.GenderEnum;
import com.github.salemalawi.medicallaboratory.model.modelDto.PatientRecordDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(value = "patients")
public class Patient {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "gender")
    private GenderEnum gender;

    @Field(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Field(name = "phone_number")
    private String phoneNumber;

    @Field(name = "records")
    private List<PatientRecordDto> records;

    @Field(name = "created_at")
    private LocalDate createAt;





}
