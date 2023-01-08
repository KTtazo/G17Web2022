/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringWeb.repositories;

import com.example.SpringWeb.modelo.OfertaPracticas;
import com.example.SpringWeb.modelo.OfertaPracticas_has_Alumno;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dsole
 */
public interface OfertaPracticas_has_AlumnoRepository extends JpaRepository<OfertaPracticas_has_Alumno, Integer>{
   
   // List<OfertaPracticas_has_Alumno> deleteOfertaPracticas_has_AlumnoByAlumno_Persona_usuario(String usuario);
}
