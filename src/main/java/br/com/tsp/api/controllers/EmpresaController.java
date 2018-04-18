package br.com.tsp.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
	
	@GetMapping(value = "/{nome}")
	public String helloName(@PathVariable("nome") String nome) {
		return "Olá " + nome;
	}
}