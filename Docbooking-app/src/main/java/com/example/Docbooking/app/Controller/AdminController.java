package com.example.Docbooking.app.Controller;

import com.example.Docbooking.app.Model.BloopGroup;
import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.Patient;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Service.DoctorService;
import com.example.Docbooking.app.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @PostMapping("doctor")
    public String adddoctor(@RequestBody Doctor doctor){
        return doctorService.adddoctor(doctor);
    }

    @GetMapping("patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("patients/Bloodgroup/{bloodGroup}")
    public List<Patient> getallpatientsbybloodgroup(@PathVariable BloopGroup bloopGroup){
        return patientService.getallpatientsbybloodgroup(bloopGroup);
    }

}
