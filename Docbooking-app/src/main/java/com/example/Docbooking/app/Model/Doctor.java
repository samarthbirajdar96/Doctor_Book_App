package com.example.Docbooking.app.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Doctor.class,property = "docId")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docId;
    private String docName;
    private String docContact;
    private Double docFee;

    @Enumerated(value = EnumType.STRING)
    private Specilization docspecilization;

    @Enumerated(value = EnumType.STRING)
    private Qualification docqualification;



    @OneToMany(mappedBy = "doctor")
    List<Appoinment> appoinments;

}
