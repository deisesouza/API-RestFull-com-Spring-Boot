package com.deise.souza.repository;

import com.deise.souza.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	
}
