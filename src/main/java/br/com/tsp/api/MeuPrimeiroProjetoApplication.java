package br.com.tsp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.tsp.api.entities.Empresa;
import br.com.tsp.api.repositories.EmpresaRepository;
import br.com.tsp.api.services.EmpresaService;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	EmpresaRepository empresaRepo;
	
	@Autowired
	private EmpresaService empresaSrv;
	
	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu primeiro projeto"); 
	}
	
	@Bean
	public CommandLineRunner commandLineRunnter() {
		return args -> {
			System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);		
						
			// insere empresa
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Empresa 1");
			empresaRepo.save(empresa);
			
			// lista todas as empresas
			List<Empresa> empresas = empresaRepo.findAll();
			empresas.forEach(System.out::println);
			
			// procura empresa com id = 1
			Empresa empresaDb = empresaRepo.findById(1L).get();
			empresaDb.setRazaoSocial("Empresa 1 IT");
			empresaRepo.save(empresaDb);
			
			// pesquisa por razão social
			System.out.println(empresaRepo.findByRazaoSocial("Empresa 1 IT"));
			
			// apaga empresa com id = 1
			empresaRepo.deleteById(1L);
			
			// lista empresas
			empresas = empresaRepo.findAll();
			System.out.println("Empresas size = " + empresas.size());
			
			empresaSrv.testarServico();
		};	
	}
}