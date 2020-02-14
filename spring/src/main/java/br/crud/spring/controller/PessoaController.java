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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.crud.spring.model.Pessoa;
import br.crud.spring.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	//injetando pessoaService
	@Autowired
	PessoaRepository pessoaRepository;

	//Usando o metodo POST, para inserir uma nova pessoa no banco
	@PostMapping
	@ResponseStatus (value = HttpStatus.CREATED )
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa) {
		try {
			return new ResponseEntity <Pessoa> (pessoaRepository.save(pessoa), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity <Pessoa> (pessoa, HttpStatus.BAD_REQUEST);
		}
	}

	//Usando o Metodo DELETE, para excluir um dado do banco
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}

	//usando metodo PUT, para pegar um usuario e atualizar os seus dados
	@PutMapping("/{id}")
	public Pessoa atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		
		Pessoa pessoaA = pessoaRepository.findPessoaById(id);
		
		pessoaA.setIdade(pessoa.getIdade());
		pessoaA.setNome(pessoa.getNome());
		
		return pessoaRepository.saveAndFlush(pessoaA);
	}

	//usando metodo GET, para pegar e listar todos os usuarios do banco de dados
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		return new ResponseEntity<List<Pessoa>>(pessoaRepository.findAll() , HttpStatus.OK);
	}

}
