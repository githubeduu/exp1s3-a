package com.example.exp1s3a;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    
    public UsuarioController(){
        usuarios.add(new Usuario(1, "Juan Perez", "1234", "174226439", "san pablo 3850", new Roles(1, "Supervisor")));
        usuarios.add(new Usuario(2, "Maria Becerra", "5678", "153765432", "monjita 321", new Roles(2, "Administrador")));
        usuarios.add(new Usuario(3, "Ruben Rojas", "9012", "119877652", "providencia 2186", new Roles(3, "Auxiliar")));
        usuarios.add(new Usuario(3, "Andrea Gonzalez", "4321", "83446158", "providencia 2186", new Roles(3, "Auxiliar")));
        usuarios.add(new Usuario(3, "Jose Miguel Larrain", "7654", "198856321", "providencia 2186", new Roles(1, "Supervisor")));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> getUsuarios() {
        if(usuarios.isEmpty()){
            return ResponseEntity.badRequest().body("Usuarios no encontrados");
        }else{
            return ResponseEntity.ok(usuarios);
        }
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int usuarioId) {
        for(Usuario usuario: usuarios){
            if(usuario.getId() == usuarioId)
            {
                return ResponseEntity.ok(usuario);
            }
         } 
         return ResponseEntity.badRequest().body("Usuario no encontrado con el ID: " + usuarioId);    
    }  

    @GetMapping("/roles")
    public ResponseEntity<?> getRoles() {
        List<Roles> roles = new ArrayList<>();
        for(Usuario usuario : usuarios)
        {
            roles.add(usuario.getRol());
        }
        if(roles.isEmpty()){
            return ResponseEntity.badRequest().body("roles no encontrados");
        }else{
            return ResponseEntity.ok(roles);
        }
    }
  
    @GetMapping("usuarios/roles/{rol}")
    public ResponseEntity<?> getUsuariosByRolId(@PathVariable String rol) {
        List<Usuario> usuarioConRol = new ArrayList<>();
        for(Usuario usuario: usuarios){
            if(usuario.getRol().getRol().equals(rol))
            {
                usuarioConRol.add(usuario);
            }
            
        }
        if(usuarioConRol.isEmpty()){
            return ResponseEntity.badRequest().body("usuario no encontrado por su rol");
        }else{
            return ResponseEntity.ok(usuarioConRol);
        }
    }

    

}