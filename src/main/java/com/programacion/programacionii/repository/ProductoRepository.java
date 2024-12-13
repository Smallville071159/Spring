package com.programacion.programacionii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacion.programacionii.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
