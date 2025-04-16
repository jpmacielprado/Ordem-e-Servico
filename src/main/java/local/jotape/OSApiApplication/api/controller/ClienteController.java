/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.jotape.OSApiApplication.api.controller;

import java.util.ArrayList;
import java.util.List;
import local.jotape.OSApiApplication.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */
@RestController
public class ClienteController {
    
    List<Cliente> listaClientes;
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
        
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1, "KGe", "kge@teste.com", "12-99999-9999"));
        listaClientes.add(new Cliente(2, "Maria", "maria@teste.com", "12-88888-8888"));
        listaClientes.add(new Cliente(3, "Joao", "joao@teste.com", "12-77777-7777"));
        
        return listaClientes;
    }
    
}
