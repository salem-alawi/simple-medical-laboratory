package com.github.salemalawi.medicallaboratory.controller;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UserController {


    @ResponseBody
    @GetMapping("/")
    public Hello getHelloWorld(@RequestParam(name = "name",defaultValue = "salem")String name,@RequestParam(name = "age",defaultValue = "1")Integer myAge){
        return new Hello("hello "+name+ " and age ="+myAge);

    }

    @QueryMapping(name="hello")
    public Hello hello22(@Argument Optional<String> name,@Argument(name = "age")Optional<Integer> myAge){

        return new Hello("hello "+name.orElse("not found")+ " and age ="+myAge.orElse(30));
    }

}

record Hello(String text){}
