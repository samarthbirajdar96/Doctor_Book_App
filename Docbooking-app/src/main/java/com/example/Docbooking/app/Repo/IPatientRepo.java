package com.example.Docbooking.app.Repo;

import com.example.Docbooking.app.Model.BloopGroup;
import com.example.Docbooking.app.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientRepo extends JpaRepository<Patient,Integer> {
    Patient findFirstByPatientEmail(String email);

    List<Patient> findByPatientBloodGroup(BloopGroup bloopGroup);
}
