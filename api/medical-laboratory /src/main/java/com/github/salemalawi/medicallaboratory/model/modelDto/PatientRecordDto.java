package com.github.salemalawi.medicallaboratory.model.modelDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientRecordDto {

    private LocalDate date;
    private String hospital;
    private String location;
    private String traceRecord;

}
