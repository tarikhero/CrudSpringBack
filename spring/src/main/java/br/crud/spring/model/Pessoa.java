package br.crud.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//passando o nome da tabela, dentro do banco, pessoas
@Entity
@Table(name = "pessoas")
public class Pessoa {

	// para ele sempre gerar numeros de id diferentes, caso já tenha dados
	// cadastrados no banco por outro lugar
	// GenerationType.AUTO, atribui o valor padrão, deixa com que o provedor de
	// persistencia decida.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")

	// a pessoa tem um um id
	private Long id;

	// a pessoa tem um nome
	private String nome;

	// a pessoa tem uma idade
	private Integer idade;

	// getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
