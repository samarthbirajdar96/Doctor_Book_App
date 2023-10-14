package com.example.Docbooking.app.Repo;

import com.example.Docbooking.app.Model.Doctor;
import com.example.Docbooking.app.Model.Qualification;
import com.example.Docbooking.app.Model.Specilization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByDocQualificationOrDocSpecilization(Specilization specilization, Qualification qualification);
}
