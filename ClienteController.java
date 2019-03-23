package com.deise.souza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import com.deise.souza.model.*;
import com.deise.souza.service.*;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	
	//ENDPOINTS
	
	//cadastrar cliente
	@RequestMapping(method=RequestMethod.POST, value="/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		
		Cliente cadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(cadastrado, HttpStatus.CREATED);
	}
	
	//buscar todos os clientes
	@RequestMapping(method=RequestMethod.GET, value="/clientes", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
		
		Collection<Cliente> buscados = clienteService.buscarTodos();
		return new ResponseEntity<>(buscados, HttpStatus.OK);
	}
	
	//Buscar cliente por ID e deletar
	@RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.buscarId(id);
		
		if(clienteEncontrado == null) {
			return new ResponseEntity<>(clienteEncontrado, HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clienteEncontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	//Buscar cliente por ID e exibir
	@RequestMapping(method=RequestMethod.GET, value="/clientes/{id}")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.buscarId(id);
		
		if(clienteEncontrado == null) {
			return new ResponseEntity<>(clienteEncontrado, HttpStatus.NOT_FOUND);
		}

			return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
		
	}
	
	//Buscar cliente e alterar
		@RequestMapping(method=RequestMethod.PUT, value="/cliente")
		public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
			
			Cliente clienteAlterado = clienteService.alterar(cliente);
			
			if(clienteAlterado == null) {
				return new ResponseEntity<>(clienteAlterado, HttpStatus.NOT_FOUND);
			}
			clienteService.alterar(clienteAlterado);
				return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
			
		}
		
}
