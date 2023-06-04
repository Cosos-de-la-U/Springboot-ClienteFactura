package com.example.clientefactura.repository;

import com.example.clientefactura.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
