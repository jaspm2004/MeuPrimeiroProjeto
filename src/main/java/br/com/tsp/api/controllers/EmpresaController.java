package br.com.tsp.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tsp.api.dtos.EmpresaDto;
import br.com.tsp.api.responses.Response;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
	
	@GetMapping(value = "/{nome}")
	public String helloName(@PathVariable("nome") String nome) {
		return "Olá " + nome;
	}
	
	@PostMapping ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto, 
			BindingResult result) {
		Response<EmpresaDto> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
	}
}