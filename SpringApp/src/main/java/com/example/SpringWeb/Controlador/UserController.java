/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringWeb.Controlador;

import com.example.SpringWeb.modelo.UserService;
import com.example.SpringWeb.modelo.Alumno;
import com.example.SpringWeb.modelo.Alumno;
import com.example.SpringWeb.modelo.Empresa;
import com.example.SpringWeb.modelo.OfertaPracticas;
import com.example.SpringWeb.modelo.OfertaPracticas_has_Alumno;
import com.example.SpringWeb.modelo.Persona;
import com.example.SpringWeb.modelo.Tutor;
import com.example.SpringWeb.repositories.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dsole
 */
@RestController
  
public class UserController {

    @RequestMapping("/")
    public String Inicio(){
        return "Inicio";
} 
    @Autowired
   private UserService userService;
    @GetMapping("/datosAlumnos")
    public List<Alumno> mostrarAlumnos(){
        return userService.findAllAlumno();
    }   
    @GetMapping("/datosSeleccion")
    public List<OfertaPracticas_has_Alumno> mostrarSeleccion(){
        return userService.findAllSeleccion();
    } 
    
    @GetMapping("/datosPracticas")
    public List<OfertaPracticas> mostrarEmpresas(){
        return userService.findAllOferta();
}   
    @PostMapping(("/guardarSeleccion"))
    public OfertaPracticas_has_Alumno guardarOfertaAlumno(@RequestBody OfertaPracticas_has_Alumno seleccion){
       return this.userService.saveOfertaPracticas_has_Alumno(seleccion);
    }
    //Añade los datos de Persona para ser utilizados poseriormente al guardar el tutor
    @PostMapping(("/guardarPersona"))
    public Persona guardarPersona(@RequestBody Persona persona){
       return this.userService.PersonaSave(persona);
    }
     @PostMapping(("/guardarTutor"))
    public Tutor guardarTutor(@RequestBody Tutor tutor,@RequestBody Persona persona){
       return this.userService.TutorSave(tutor);
    }
}
