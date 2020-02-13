package br.crud.spring.service;

import java.util.List;

import br.crud.spring.model.Pessoa;

public interface PessoaService {

	Pessoa cadastrar(Pessoa pessoa);
	String remover(Long id);
	List<Pessoa> listar();
	Pessoa atualizar(Pessoa pessoa);
	
}
