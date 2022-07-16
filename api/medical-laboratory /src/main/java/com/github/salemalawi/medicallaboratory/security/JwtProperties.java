package com.github.salemalawi.medicallaboratory.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
public class JwtProperties {


    private String secretKey = "passwordpasswordpasswordpassword";

    // validity in milliseconds
    private int validityInMs = 3600000 * 20; // 1h * 20

}
