package br.crud.spring.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.crud.spring.model.Pessoa;
import br.crud.spring.repository.PessoaRepository;
import br.crud.spring.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa cadastrar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public String remover(Long id) {
		String response = "";
		
		if(pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
			response = "Removido com sucesso";
		} else {
			response = "Não foi remover";
		}
		return response;
	}

	@Override
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa atualizar(Pessoa pessoa) {
		return pessoaRepository.saveAndFlush(pessoa);
	}
	
}
