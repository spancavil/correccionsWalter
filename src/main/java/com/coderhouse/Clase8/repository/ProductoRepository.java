package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto,Integer> {}
