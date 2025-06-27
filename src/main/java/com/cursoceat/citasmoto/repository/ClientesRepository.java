package com.cursoceat.citasmoto.repository;

import com.cursoceat.citasmoto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
}
