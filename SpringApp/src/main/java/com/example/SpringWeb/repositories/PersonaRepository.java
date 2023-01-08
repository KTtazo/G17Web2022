/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringWeb.repositories;

import com.example.SpringWeb.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dsole
 */
public interface PersonaRepository extends JpaRepository <Persona, Integer> {
    
}
