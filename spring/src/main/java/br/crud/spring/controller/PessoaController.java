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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.crud.spring.model.Pessoa;
import br.crud.spring.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	//injetando pessoaService
	@Autowired
	PessoaService pessoaService;

	//Usando o metodo POST, para inserir uma nova pessoa no banco
	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa) {
		try {
			return new ResponseEntity <Pessoa> (pessoaService.cadastrar(pessoa), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity <Pessoa> (pessoa, HttpStatus.BAD_REQUEST);
		}
	}

	//Usando o Metodo DELETE, para excluir um dado do banco
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		return new ResponseEntity<String>(pessoaService.remover(id), HttpStatus.OK);
	}

	//usando metodo PUT, para pegar um usuario e atualizar os seus dados
	@PutMapping
	public ResponseEntity<Pessoa> atualizar( @Valid @RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.atualizar(pessoa), HttpStatus.OK);
	}

	//usando metodo GET, para pegar e listar todos os usuarios do banco de dados
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		return new ResponseEntity<List<Pessoa>>(pessoaService.listar(), HttpStatus.OK);
	}

}
