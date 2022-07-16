package com.github.salemalawi.medicallaboratory.security;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class TokenTypeWrapper {

    public static final String GENERAL_AUTH = "x-authorization";
//    public static final String VISITOR_HEADER = "sId";
//    public static final String SYSTEM_HEADER = "x-event-system";

    private TokenTypeEnum type;
    private String token;

}
