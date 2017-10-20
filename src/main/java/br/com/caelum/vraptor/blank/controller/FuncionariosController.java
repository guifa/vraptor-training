package br.com.caelum.vraptor.blank.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.modelo.Funcionario;
import br.com.caelum.vraptor.blank.utils.DataBaseMemoryFuncionario;
import br.com.caelum.vraptor.validator.Validations;

@Resource
@Path("/funcionarios")
public class FuncionariosController {
	
	private DataBaseMemoryFuncionario dbMemory;
	private Result result;
	private Validator validator;

	private FuncionariosController(DataBaseMemoryFuncionario dbMemory,  Result result, Validator validator) {
		this.dbMemory = dbMemory;
		this.result = result;
		this.validator = validator;
	}	
	
	@Path("cadastro")
	public void form() {
		
	}
	
	@Path({"", "/"})
	public List<Funcionario> lista(Funcionario funcionario){
		result.include("funcionarios", dbMemory.pesquisa(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento()));
		return dbMemory.todos();		
	}
	
	@Post
	@Path("adicionar")
	public void adiciona(Funcionario funcionario) {
		if(dbMemory.busca(funcionario.getMatricula()) != null) {
			validaFuncionario(funcionario);
			dbMemory.atualiza(funcionario);
		}else {
			validaFuncionario(funcionario);
			dbMemory.salva(funcionario);
		}
		 
		
	    dbMemory.salva(funcionario);
		result.redirectTo(FuncionariosController.class).lista(new Funcionario());
	}
	
	
	@Delete("deleta/{matricula}")
	public void deleta(int matricula) {
		dbMemory.delete(matricula);
		result.redirectTo(this).lista(new Funcionario());
	}
	
	@Put
	@Path("atualiza")
	public void atualiza(Funcionario funcionario) {		
		dbMemory.atualiza(funcionario);
		
		result.include("funcionarios", dbMemory.todos());
		result.redirectTo(this).lista(new Funcionario());
	}
	
	@Get
	@Path("busca")
	public void busca(int matricula) {
		result.include("funcionario", dbMemory.busca(matricula));
		result.redirectTo(this).form();
	}
	
	
	@Path("pesquisa")
	public List<Funcionario> pesquisa(Funcionario funcionario){
		result.include("funcionarios", dbMemory.pesquisa(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento()));
		result.redirectTo(this).lista(funcionario);
		return dbMemory.pesquisa(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento());
	}
	
	public void validaFuncionario(final Funcionario funcionario) {
		validator.checking(new Validations() { {
			 that(!funcionario.getNome().isEmpty(), "funcionario.nome", "nome.vazio");
//			 that(!(funcionario.getDataNascimento() != null), "funcionario.dataNascimento", "dataNascimento.vazia");
			 that(funcionario.getMatricula() > 0, "funcionario.matricula", "matricula.invalida");
	        } });
	    validator.onErrorUsePageOf(FuncionariosController.class).form();
	}
}
