package com.example.clientefactura.repository;

import com.example.clientefactura.model.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
}
