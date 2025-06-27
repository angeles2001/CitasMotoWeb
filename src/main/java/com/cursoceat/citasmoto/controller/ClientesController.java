package com.cursoceat.citasmoto.controller;

import com.cursoceat.citasmoto.model.Cliente;
import com.cursoceat.citasmoto.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientesController {

    @Autowired
    private final ClientesRepository clientesRepository;

    public ClientesController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("listaClientes", clientesRepository.findAll());
        return "clientes";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "lista-clientes";
    }


    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clientesRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        Cliente cliente = clientesRepository.findById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "lista-clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clientesRepository.deleteById(id);
        return "redirect:/clientes";
    }




}
