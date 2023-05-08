/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoInt.abigailGuzman.Interface;

import com.ProyectoInt.abigailGuzman.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //lista de personas
    public List<Persona> getPersona();
    //guardar un objeto persona
    public void  savePersona(Persona persona);
    //eliminar a un objeto
    public void deletePersona(Long id);
    //buscar persona por ID
    public Persona findPersona(Long id);

  
}