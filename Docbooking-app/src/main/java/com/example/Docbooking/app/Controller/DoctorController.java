package com.example.Docbooking.app.Controller;

import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

   @GetMapping ("doctors")
    public List<Doctor> getAllDoctors(@RequestBody AuthenticationInputDto authInfo){
       return doctorService.getAllDoctors(authInfo);
   }

    @GetMapping("doctor/id/{id}")
    public Doctor getDoctorBYid(@PathVariable Integer id){
        return doctorService.getDoctorBYid(id);
    }
}
