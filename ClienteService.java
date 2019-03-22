package com.deise.souza.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deise.souza.model.Cliente;
import com.deise.souza.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
		
	//REGRAS DE NEGOCIO
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();

	}
	
		
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}

