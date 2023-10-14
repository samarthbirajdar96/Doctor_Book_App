package com.example.Docbooking.app.Repo;

import com.example.Docbooking.app.Model.PauthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepo extends JpaRepository<PauthenticationToken,Integer> {
    PauthenticationToken findFirstByTokenValue(String tokenValue);
}
