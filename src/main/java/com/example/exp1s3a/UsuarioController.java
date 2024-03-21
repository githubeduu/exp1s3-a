package com.example.exp1s3a;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
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
        usuarios.add(new Usuario(3, "Juan Perez", "9012", "119877652", "providencia 2186", new Roles(3, "Auxiliar")));
        usuarios.add(new Usuario(3, "Andrea Gonzalez", "4321", "83446158", "providencia 2186", new Roles(3, "Auxiliar")));
        usuarios.add(new Usuario(3, "Juan Perez", "7654", "198856321", "providencia 2186", new Roles(1, "Supervisor")));
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int usuarioId) {
        for(Usuario usuario: usuarios){
            if(usuario.getId() == usuarioId)
            {
                return ResponseEntity.ok(usuario);
            }
         } 
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con el ID: " + usuarioId);    
    }  
  
    @GetMapping("usuarios/roles/{rolId}")
    public List<Usuario> getUsuariosByRolId(@PathVariable int rolId) {
        List<Usuario> usuarioConRol = new ArrayList<>();
        for(Usuario usuario: usuarios){
            if(usuario.getRol().getId() == rolId)
            {
                usuarioConRol.add(usuario);
            }
            
        }
        return usuarioConRol;
    }
   

}