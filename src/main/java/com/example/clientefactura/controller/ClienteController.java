package com.example.clientefactura.controller;

import com.example.clientefactura.model.Cliente;
import com.example.clientefactura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable Long id){
        return clienteService.getCliente(id);
    }

    @PostMapping
    public Cliente postCliente(@RequestBody Cliente cliente){
        return clienteService.postCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        try {
            Cliente data = clienteService.getCliente(id).get();
            boolean ok = clienteService.deleteCliente(id);
            if(ok) return ResponseEntity.ok(String.format("%s was removed!", data.getNombre()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s was NOT removed!, something happened!", data.getNombre()));
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Something wrong happened!"));
        }
    }
}
