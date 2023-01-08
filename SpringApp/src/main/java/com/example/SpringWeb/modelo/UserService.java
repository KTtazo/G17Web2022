/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringWeb.modelo;

import com.example.SpringWeb.repositories.AlumnoRepository;
import com.example.SpringWeb.repositories.EmpresaRepository;
import com.example.SpringWeb.repositories.InformePracticasRepository;
import com.example.SpringWeb.repositories.OfertaPracticasRepository;
import com.example.SpringWeb.repositories.OfertaPracticas_has_AlumnoRepository;
import com.example.SpringWeb.repositories.PersonaRepository;
import com.example.SpringWeb.repositories.TutorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dsole
 */
@Service
public class UserService {
    //Metodos utilizados para Alumno
    @Autowired
    private AlumnoRepository alumnoRepository;
    public List<Alumno> findAllAlumno(){
        return alumnoRepository.findAll();
    }
    public List<Alumno> getAlumnoByNombre(String usuario){
        return alumnoRepository.getByUsuario(usuario);
    }
    //Metodos utilizados para Empresa
    @Autowired
    private EmpresaRepository empresaRepository;
    
    public Empresa EmpresaSave(Empresa empresa){
        return empresaRepository.save(empresa);
    }
    public void deleteEmpresa(String cif){
        empresaRepository.deleteByCif(cif);
    }
    //Metodos utilizados para InformePracticas
    @Autowired
    private InformePracticasRepository informePracticasRepository;
    public void deleteInformeByAlumno(String usuario){
        //informePracticasRepository.deleteByalumno_Persona_usuario(usuario);
    }
   public InformePracticas InformeSave(InformePracticas informePracticas){
        return informePracticasRepository.save(informePracticas);
    }
   //Metodos para OfertasPracticas
   @Autowired
   OfertaPracticasRepository ofertaPracticasRepository;
   public List<OfertaPracticas> findAllOferta(){
        return ofertaPracticasRepository.findAll();
    }
   public void deleteOfertaPracticas(int idOfertaPracticas){
        ofertaPracticasRepository.deleteById(idOfertaPracticas);
    }
   public OfertaPracticas OfertaSave(OfertaPracticas ofertaPracticas){
        return ofertaPracticasRepository.save(ofertaPracticas);
    }
   @Autowired
   private PersonaRepository personaRepository;
   public Persona PersonaSave(Persona persona){
        return personaRepository.save(persona);
    }
   //Metodos para OfertaPracticas_has_Alumno
   @Autowired
   OfertaPracticas_has_AlumnoRepository ofertaPracticas_has_AlumnoRepository;
   public void deleteOfertaPracticas_has_Alumno(String usuario){
        //ofertaPracticas_has_AlumnoRepository.deleteOfertaPracticas_has_AlumnoByAlumno_Persona_usuario(usuario);
    }
   public OfertaPracticas_has_Alumno saveOfertaPracticas_has_Alumno(OfertaPracticas_has_Alumno seleccion){
        return ofertaPracticas_has_AlumnoRepository.save(seleccion);
    }
   public List<OfertaPracticas_has_Alumno> findAllSeleccion(){
        return ofertaPracticas_has_AlumnoRepository.findAll();
    }
    @Autowired
    private TutorRepository tutorRepository;
    
    public Tutor TutorSave(Tutor tutor){
        return tutorRepository.save(tutor);
    }
}