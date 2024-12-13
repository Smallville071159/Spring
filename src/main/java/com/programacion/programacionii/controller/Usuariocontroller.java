package com.programacion.programacionii.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.programacionii.models.Usuario;
import com.programacion.programacionii.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Usuariocontroller {

    @Autowired
    public UsuarioRepository UsuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getuUsuarios(){
        return UsuarioRepository.findAll();
    }
       @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return UsuarioRepository.save(usuario);
    }
     

   
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return UsuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombres(usuarioDetails.getNombres());
                    usuario.setDireccion(usuarioDetails.getDireccion());
                    usuario.setEps(usuarioDetails.getEps());
                    Usuario updatedUsuario = UsuarioRepository.save(usuario);
                    return ResponseEntity.ok(updatedUsuario);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}


