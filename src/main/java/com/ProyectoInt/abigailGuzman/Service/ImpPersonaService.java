/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.ProyectoInt.abigailGuzman.Service;

import com.ProyectoInt.abigailGuzman.Entity.Persona;
import com.ProyectoInt.abigailGuzman.Interface.IPersonaService;
import com.ProyectoInt.abigailGuzman.Repository.IPersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class ImpPersonaService implements IPersonaService{
@Autowired IPersonaRepository ipersonaRepository;

@Override
public List<Persona> getPersona(){
    List<Persona> persona = ipersonaRepository.findAll();
    return persona;
}
@Override
    public void savePersona (Persona persona){
        ipersonaRepository.save(persona);
    }
@Override
    public void deletePersona (int id){
        ipersonaRepository.deleteById(id);
    }
@Override
    public Persona findPersona(int id){
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
   
}
*/




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
 
package com.ProyectoInt.abigailGuzman.Service;
import com.ProyectoInt.abigailGuzman.Entity.Persona;
import com.ProyectoInt.abigailGuzman.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class ImpPersonaService {
@Autowired 
IPersonaRepository ipersonaRepository;
 
 public List<Persona> list(){
        return ipersonaRepository.findAll();  
    }
    public Optional<Persona> getOne (int id){
        return ipersonaRepository.findById(id);     
    }
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    public void save(Persona persona){
        ipersonaRepository.save(persona);
    }
    public void delete(int id){
        ipersonaRepository.deleteById(id);
    }
    public boolean existsById(int id){
         return ipersonaRepository.existsById(id);         
    }
    public boolean existsByNombre(String nombre){
         return ipersonaRepository.existsByNombre(nombre);
    }
 public Persona findPersona(int id){
       return ipersonaRepository.findById(id).orElse(null);
         
       }
    }

