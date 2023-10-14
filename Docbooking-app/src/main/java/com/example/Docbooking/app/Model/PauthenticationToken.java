package com.example.Docbooking.app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PauthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer tokenId;

    private  String tokenValue;

    private LocalDateTime tokenCreationTime;

    //each token  link patient

    @OneToOne
    @JoinColumn(name="fk_patientId")
    Patient patient;

    public PauthenticationToken(Patient patient) {
        this.patient=patient;
        this.tokenValue= UUID.randomUUID().toString();
        this.tokenCreationTime=LocalDateTime.now();
    }
}
