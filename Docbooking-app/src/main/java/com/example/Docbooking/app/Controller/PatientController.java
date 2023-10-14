package com.example.Docbooking.app.Controller;

import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.Patient;
import com.example.Docbooking.app.Model.Qualification;
import com.example.Docbooking.app.Model.Specilization;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Model.dto.ScheduleDto;
import com.example.Docbooking.app.Model.dto.SignInInputDto;
import com.example.Docbooking.app.Service.DoctorService;
import com.example.Docbooking.app.Service.PatientService;
import com.example.Docbooking.app.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService scheduleService;

    @Autowired
    DoctorService doctorService;


    //signUp

    @PostMapping("patient/signUp")
    public String patientSignUp(@RequestBody Patient patient){
        return patientService.patientSignUp(patient);
    }


//patient signIn

    @PostMapping("patient/signIn")
    public String patientSignIn(@RequestBody SignInInputDto signInInputDto){
        return patientService.patientSignIn(signInInputDto);
    }


//patient signOut

    @DeleteMapping ("patient/signOut")
    public String patientSignOut(@RequestBody AuthenticationInputDto authInfo){
        return patientService.patientSignOut(authInfo);
    }





//schedule aappoinment

    @PostMapping("patient/appoinment/schedule")
    public String scheduleappoinment(@RequestBody ScheduleDto scheduleDto){
     return   scheduleService.scheduleappoinment(scheduleDto.getAuthInfo(),scheduleDto.getAppoinment());
    }

    @DeleteMapping("patient/appoinment/{appointmentid}/cancle")
    public String cancleappoinment(@RequestBody AuthenticationInputDto authInfo, @PathVariable Integer appointmentid){
        return   scheduleService.cancleappoinment(authInfo,appointmentid);
    }


    @GetMapping("doctors/specification/{specilization}/or/qualification/{qualification}")

    public List<Doctor> getDoctorsByQualificationOrSpecification(@PathVariable Specilization specilization, @PathVariable Qualification qualification){
        return doctorService.getDoctorsByQualificationOrSpecification(specilization,qualification);
    }

    }



