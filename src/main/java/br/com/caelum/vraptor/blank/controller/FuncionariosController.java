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
	
	@Path("novo")
	public void novo() {
		
	}
	
	public List<Funcionario> lista(){
		return dbMemory.todos();		
	}
	
	@Post
	public void adiciona(final Funcionario funcionario) {
//		 validator.checking(new Validations() { {
//			 that(!funcionario.getNome().isEmpty(), "funcionario.nome", "nome.vazio");
//			 that(!(funcionario.getDataNascimento() != null), "funcionario.dataNascimento", "dataNascimento.vazia");
//			 that(funcionario.getMatricula() > 0, "funcionario.matricula", "matricula.invalida");
//	        } });
//	    validator.onErrorUsePageOf(FuncionariosController.class).novo();
		
	    dbMemory.salva(funcionario);
		result.redirectTo(FuncionariosController.class).lista();
	}
	
	@Delete
	@Path("{funcionario}")
	public boolean deleta(Funcionario funcionario) {
		return dbMemory.delete(funcionario);
	}
	
	@Put
	@Path("{funcionario}")
	public boolean atualiza(Funcionario funcionario) {
		return dbMemory.atualiza(funcionario);
	}
	
//	@Get
//	@Path("/funcionarios/{funcionario.matricula}")
//	public Funcionario busca(int matricula) {
//		return dbMemory.busca(matricula);
//	}
	
//	@Get
//	@Path("/funcionarios")
//	public boolean existe(Funcionario funcionario) {
//		return dbMemory.contem(funcionario);
//	}
	
	@Get
	@Path("/funcionarios")
	public List<Funcionario> pesquisa(int matricula, String nome, Date dataNascimento){
		return dbMemory.pesquisa(matricula, nome, dataNascimento);
	}
}
