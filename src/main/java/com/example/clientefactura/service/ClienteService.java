package com.example.clientefactura.service;

import com.example.clientefactura.model.Cliente;
import com.example.clientefactura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<Cliente> getClientes(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente postCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public boolean deleteCliente(Long id){
        try {
             clienteRepository.deleteById(id);
             return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
