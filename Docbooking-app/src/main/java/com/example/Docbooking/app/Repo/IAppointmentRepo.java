package com.example.Docbooking.app.Repo;

import com.example.Docbooking.app.Model.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appoinment,Integer> {
}
