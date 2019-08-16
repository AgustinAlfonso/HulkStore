package com.tangami.controller;

import com.tangami.service.SolicitudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/nami/tango")
public class TangamiController {

    @Autowired
    private SolicitudImpl solicitud;

    @GetMapping(value = "/getPerson/{id}")
    public String getPerson(@PathVariable String id){
        return solicitud.getPerson(id);
    }
}
