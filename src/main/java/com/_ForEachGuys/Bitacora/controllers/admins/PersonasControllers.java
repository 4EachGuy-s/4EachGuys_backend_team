package com._ForEachGuys.Bitacora.controllers.admins;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._ForEachGuys.Bitacora.services.personas.PersonasService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v2/")
public class PersonasControllers {
    /* Servicio de personas */
    private final PersonasService personasService;
    
    @GetMapping("/personas")
    public String getMethodName(@RequestParam(name = "name") String param) {
        return personasService.buscarUsuario(param).toString();
    }
    
}
