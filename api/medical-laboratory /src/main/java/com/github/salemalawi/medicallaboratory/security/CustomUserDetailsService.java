package com.github.salemalawi.medicallaboratory.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService {

    @Autowired
    private JwtTokenProvider tokenProvider;



}
