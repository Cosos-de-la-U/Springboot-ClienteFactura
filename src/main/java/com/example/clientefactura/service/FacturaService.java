package com.example.clientefactura.service;

import com.example.clientefactura.model.Factura;
import com.example.clientefactura.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

    public ArrayList<Factura> getFacturas(){
        return (ArrayList<Factura>) facturaRepository.findAll();
    }

    public Optional<Factura> getFactura(Long id){
        return facturaRepository.findById(id);
    }

    public Factura postFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public boolean deleteFactura(Long id){
        try {
             facturaRepository.deleteById(id);
             return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
