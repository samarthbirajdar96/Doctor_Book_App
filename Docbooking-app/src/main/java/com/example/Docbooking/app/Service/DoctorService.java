package com.example.Docbooking.app.Service;

import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.Qualification;
import com.example.Docbooking.app.Model.Specilization;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Repo.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {

    @Autowired
    IDoctorRepo doctorRepo;

    @Autowired
    PTokenService pTokenService;

    public List<Doctor> getAllDoctors(AuthenticationInputDto authInfo) {
        if (pTokenService.autheticate(authInfo)) {
            return doctorRepo.findAll();
        } else {
            return null;
        }
    }

    public String adddoctor(Doctor doctor) {
        Integer docId=doctor.getDocId();

        if(docId!=null && doctorRepo.existsById(docId)){
            return "Doctor Already exits!!!";
        }
        doctor.setAppoinments(null);

        doctorRepo.save(doctor);
        return "Doctor added!!!!";
    }

    public Doctor getDoctorBYid(Integer id) {
        return doctorRepo.findById(id).orElseThrow();
    }

    public List<Doctor> getDoctorsByQualificationOrSpecification(Specilization specilization, Qualification qualification) {
       List<Doctor>doctors= doctorRepo.findByDocQualificationOrDocSpecilization(specilization,qualification);
       for(Doctor doctor:doctors){
           doctor.setAppoinments(null);
       }
       return doctors;
    }
}

