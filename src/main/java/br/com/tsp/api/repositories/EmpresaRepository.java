package br.com.tsp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tsp.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	public Empresa findByRazaoSocial(String razaoSocial);	
}