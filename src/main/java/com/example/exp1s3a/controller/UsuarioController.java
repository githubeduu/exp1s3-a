package com.example.exp1s3a.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exp1s3a.DTO.CreacionUsuarioDTO;
import com.example.exp1s3a.model.Auth;
import com.example.exp1s3a.model.Roles;
import com.example.exp1s3a.model.Usuario;
import com.example.exp1s3a.service.AuthService;
import com.example.exp1s3a.service.RolesService;
import com.example.exp1s3a.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolesService rolesService;

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody  String username, @RequestBody  String password) {
        if (authService.validatePassword(username, password)) {
            return ResponseEntity.ok("Contraseña válida");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }
    }
    
    @GetMapping
    public List<Usuario> getUsuarios() {       
       return usuarioService.getAllUsuario();       
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } 
    }   
  
    @PostMapping
    public ResponseEntity<?> createUsuario(@Validated @RequestBody Usuario usuario) {
      try {      
              Roles rol = rolesService.getRolesById(usuario.getRolId()).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

              usuario.setRol(rol);   
              Usuario nuevoUsuario = usuarioService.createUsuario(usuario);

            //   Auth auth = new Auth();
            //   auth.setUsername(usuario.getUsername());
            //   auth.setPassword(usuario.getPassword());
            //   auth = authService.createAuth(auth);

               return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario:          " + e);
             }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    try{        
        Optional<Usuario> usuarioExistente = usuarioService.getUsuarioById(id);
        if(usuarioExistente.isPresent())
        {
            Usuario usuarioActual = usuarioExistente.get();

            if(usuario.getRolId() != null){           
                Roles rol = rolesService.getRolesById(usuario.getRolId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
                usuarioActual.setRol(rol);
            }    
  

            if(usuario.getDireccion() != null){               
                usuarioActual.setDireccion((usuario.getDireccion()));            
            }

            if(usuario.getComuna() != null){
                usuarioActual.setComuna(usuario.getComuna());            
            }           
         
            Usuario usuarioActualizado = usuarioService.updateUsuario(id, usuarioActual);
            return ResponseEntity.ok(usuarioActualizado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } 
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el usuario:          " + e);
     }      
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
    Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        if (usuario.isPresent()) {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
}


}