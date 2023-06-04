package com.example.clientefactura.controller;

import com.example.clientefactura.model.Factura;
import com.example.clientefactura.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("factura")
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping
    public ArrayList<Factura> getFacturas(){
        return facturaService.getFacturas();
    }

    @GetMapping("/{id}")
    public Optional<Factura> getFactura(@RequestParam Long id){
        return facturaService.getFactura(id);
    }

    @PostMapping
    public Factura postFactura(@RequestBody Factura factura){
        return facturaService.postFactura(factura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        try {
            Factura data = facturaService.getFactura(id).get();
            boolean ok = facturaService.deleteFactura(id);
            if(ok) return ResponseEntity.ok(String.format("%s was removed!", data.getFacturaId()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s was NOT removed!, something happened!", data.getFacturaId()));
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Something wrong happened!"));
        }
    }
}
