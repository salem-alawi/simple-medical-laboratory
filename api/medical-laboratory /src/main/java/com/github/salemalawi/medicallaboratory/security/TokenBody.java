package com.github.salemalawi.medicallaboratory.security;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenBody {

    private String token;
    private String type;

    public TokenBody(TokenTypeWrapper tokenTypeWrapper) {
        this.token = tokenTypeWrapper.getToken();
        this.type = "Bearer";
    }
}
