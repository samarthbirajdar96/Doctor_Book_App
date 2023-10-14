package com.example.Docbooking.app.Model.dto;

import com.example.Docbooking.app.Model.Appoinment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

    AuthenticationInputDto authInfo;
    Appoinment appoinment;
}
