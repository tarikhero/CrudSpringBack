package br.crud.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.crud.spring.model.Pessoa;
import br.crud.spring.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	
	@PostMapping("/cadastrar")
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa) {
		try {
			return new ResponseEntity<Pessoa>(pessoaService.cadastrar(pessoa), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		return new ResponseEntity<String>(pessoaService.remover(id), HttpStatus.OK);
	}

	
	@PutMapping("/atualizar")
	public ResponseEntity<Pessoa> atualizar(@Valid @RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.cadastrar(pessoa), HttpStatus.OK);
	}

	//localhost:8080/listar lista as pessoas listadas no bd
	@GetMapping("/listar")
	public ResponseEntity<List<Pessoa>> listar() {
		return new ResponseEntity<List<Pessoa>>(pessoaService.listar(), HttpStatus.OK);
	}

}
