package com.example.Docbooking.app.Service;

import com.example.Docbooking.app.Model.PauthenticationToken;
import com.example.Docbooking.app.Model.dto.AuthenticationInputDto;
import com.example.Docbooking.app.Repo.IPTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {

    @Autowired
    IPTokenRepo iptokenRepo;

    public void createToken(PauthenticationToken token) {
        iptokenRepo.save(token);
    }

    public void delete(String tokenValue) {
        PauthenticationToken token=iptokenRepo.findFirstByTokenValue(tokenValue);
        iptokenRepo.delete(token);
    }

    public boolean autheticate(AuthenticationInputDto authInfo) {
        String email=authInfo.getEmail();
        String tokenValue=authInfo.getTokenValue();
        PauthenticationToken token=iptokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null){
             return token.getPatient().getPatientEmail().equals(email);
        }else{
        return false;
        }

    }


}
