/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.ProyectoInt.abigailGuzman.Controller;

import com.ProyectoInt.abigailGuzman.Entity.Persona;
import com.ProyectoInt.abigailGuzman.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontend-argeprog.web.app")

public class PersonaController {
    
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "la persona fue creada correctamente";
    }
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        ipersonaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

    @PutMapping("/editar/{id}")
     public Persona editPersona(@PathVariable int id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("descripcion") String nuevoDescripcion,
                                @RequestParam("img") String nuevoImg){
          Persona persona = ipersonaService.findPersona(id);
         
         persona.setNombre(nuevoNombre);
         persona.setApellido(nuevoApellido);
         persona.setDescripcion(nuevoDescripcion);
         persona.setImg(nuevoImg);
         
         ipersonaService.savePersona(persona);
         return persona;
     }
     @GetMapping("/traer/perfil")
     public Persona findPersona(){
         return ipersonaService.findPersona((int)1);
     }
             }*/



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
 
package com.ProyectoInt.abigailGuzman.Controller;

import com.ProyectoInt.abigailGuzman.Dto.dtoPersona;
import com.ProyectoInt.abigailGuzman.Entity.Persona;
import com.ProyectoInt.abigailGuzman.Security.Controller.Mensaje;
import com.ProyectoInt.abigailGuzman.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontend-argeprog.web.app")

public class PersonaController {

    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/traer/perfil")
    public ResponseEntity<List<Persona>> list(){
    List<Persona> list = personaService.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }

  @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
    }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
   
    @DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable("id") int id){
if(!personaService.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
}
personaService.delete(id);
return new ResponseEntity(new Mensaje("persona Eliminada"),HttpStatus.OK);
}

 @PostMapping("/crear")
public String createPersona (@RequestBody Persona persona){
    personaService.save(persona);
    return "la persona fue creada";
}

@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
   //Validamos si existe id// 
 if(!personaService.existsById(id)){
     return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
 }
 if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
 }
 if(StringUtils.isBlank(dtopersona.getNombre())){
     return new ResponseEntity (new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
 }
 Persona persona = personaService.getOne(id).get();
 persona.setNombre(dtopersona.getNombre());
 persona.setApellido(dtopersona.getApellido());
persona.setDescripcion(dtopersona.getDescripcion());
persona.setImg(dtopersona.getImg());
 
 personaService.save(persona);
 return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
     }

/*
 @GetMapping("/traer/perfil")
     public Persona findPersona(){
        Persona persona =  personaService.findPersona((int)1);
    return persona;
     }*/}

  


