package com.example.Docbooking.app.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationInputDto {

    private  String email;
    private  String tokenValue;



}
