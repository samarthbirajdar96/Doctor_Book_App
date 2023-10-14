package com.example.Docbooking.app.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Appoinment.class,property = "appoinmentId")
public class Appoinment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Integer appoinmentId;
    private String appoinmentDesc;

    LocalDateTime appCreationTime;
    LocalDateTime appScheduleTime;


    @ManyToOne
    @JoinColumn(name ="fk_docId" )
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name="fk_patientId")
    Patient patient;



}
