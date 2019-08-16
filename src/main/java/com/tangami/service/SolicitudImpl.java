package com.tangami.service;


import org.springframework.stereotype.Service;

@Service
public class SolicitudImpl implements Solicitud {

    @Override
    public String getPerson(String id) {
        if (id != null){
            return "OLA";
        }else{
            return "CHAU";
        }

    }
}
