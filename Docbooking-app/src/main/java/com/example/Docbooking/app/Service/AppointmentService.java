package com.example.Docbooking.app.Service;

import com.example.Docbooking.app.Model.Appoinment;
import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.Patient;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Repo.IAppointmentRepo;
import com.example.Docbooking.app.Repo.IDoctorRepo;
import com.example.Docbooking.app.Repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepo appointmentRepo;


    @Autowired
    PTokenService pTokenService;

    @Autowired
    IPatientRepo patientRepo;

    @Autowired
    IDoctorRepo doctorRepo;

    public String scheduleappoinment(AuthenticationInputDto authInfo, Appoinment appoinment) {
        if (pTokenService.autheticate(authInfo)) {

            String email = authInfo.getEmail();

            Patient expatient = patientRepo.findFirstByPatientEmail(email);

            appoinment.setPatient(expatient);

            Integer docId = appoinment.getDoctor().getDocId();
            Doctor doc=doctorRepo.findById(docId).orElseThrow();

            appoinment.setDoctor(doc);

            if (doc!=null) {
                appoinment.setAppCreationTime(LocalDateTime.now());
                appointmentRepo.save(appoinment);
                return "appointment booked at " +appoinment.getAppScheduleTime()+"WITH DR."+doc.getDocName();

            } else {
                return "Doctor does not exist, Could not book appointment!!";
            }


        } else {
            return "un authorised access!!!!";
        }

    }

    public String cancleappoinment(AuthenticationInputDto authInfo, Integer appointmentid) {
        if (pTokenService.autheticate(authInfo)) {

            String email = authInfo.getEmail();

            Patient expatient = patientRepo.findFirstByPatientEmail(email);

            Appoinment Exappointment=appointmentRepo.findById(appointmentid).orElseThrow();

            if(Exappointment.getPatient().equals(expatient)){
                appointmentRepo.deleteById(appointmentid);
                return "appointment with "+ Exappointment.getDoctor().getDocName()+"has been cancelled";


            }else{
                return "Unauthorized access!!!!";
            }
        }
        return "Unauthenticated access!!!";
    }
}
