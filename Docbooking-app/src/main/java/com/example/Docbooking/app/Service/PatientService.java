package com.example.Docbooking.app.Service;

import com.example.Docbooking.app.Model.BloopGroup;
import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.Patient;
import com.example.Docbooking.app.Model.PauthenticationToken;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Model.dto.SignInInputDto;
import com.example.Docbooking.app.Repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepo patientRepo;

    @Autowired

    PTokenService pTokenService;


    public String patientSignUp(Patient patient) {

        String email = patient.getPatientEmail();

        Patient existpatient = patientRepo.findFirstByPatientEmail(email);

        if (existpatient != null) {
            return "email already in use !!";
        }

        String password = patient.getPatientPassword();
        try {
            String encryptcryptPass = PasswordEncryptor.encrypt(password);
            patient.setPatientPassword(encryptcryptPass);

            patientRepo.save(patient);
            return "patient registered !!!";

        } catch (NoSuchAlgorithmException e) {
            return "Internal server error ";
        }
    }

    public String patientSignIn(SignInInputDto signInInputDto) {

        String email = signInInputDto.getEmail();

        Patient expatient = patientRepo.findFirstByPatientEmail(email);

        if (expatient == null) {
            return "email not found plz signUp again!!";
        }

        String password = signInInputDto.getPassword();

        try {
            String pass = PasswordEncryptor.encrypt(password);
            if (expatient.getPatientPassword().equals(pass)) {
                PauthenticationToken token = new PauthenticationToken(expatient);
                pTokenService.createToken(token);
                 token.getTokenValue();
                 EmailService.sendmail(email,"otp after login",token.getTokenValue());
                 return "check email for otp";

            } else {
                return "Invalid user";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal server user!!";
        }
    }

    public String patientSignOut(AuthenticationInputDto authInfo) {
        if (pTokenService.autheticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            pTokenService.delete(tokenValue);
            return "successful signOut!!!!";

        } else {
            return "unauthenticate access!!!";
        }
    }

    public List<Patient> getAllPatients() {
        return  patientRepo.findAll();
    }

    public List<Patient> getallpatientsbybloodgroup(BloopGroup bloopGroup) {
        List<Patient>  patients=patientRepo.findByPatientBloodGroup(bloopGroup);

        for(Patient patient:patients){
            patient.setAppoinments(null);
        }
        return patients;

    }
}