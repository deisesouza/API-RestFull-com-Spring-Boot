package com.deise.souza.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.deise.souza.model.Cliente;

@Service
public class ClienteService {

	private Map<Integer, Cliente> clientes = new HashMap<>();
	private Integer proximoId=1;
	
	//REGRA NEGOCIO
	public Cliente cadastrar(Cliente cliente) {
		
		cliente.setId(proximoId);
		proximoId++; 	
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}
	
	public Collection<Cliente> buscarTodos(){
		return clientes.values();
	}
	
	public Cliente buscarId(Integer id) {
		return clientes.get(id);
	}
	
	
	public void excluir(Cliente cliente) {
		clientes.remove(cliente.getId());
	}
	
	
	public Cliente alterar(Cliente cliente) {
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}
	
}
