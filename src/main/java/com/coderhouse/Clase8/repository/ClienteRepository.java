package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
   List<Cliente> findByNombreLike(String name);
}