package com.programacion.programacionii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacion.programacionii.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
