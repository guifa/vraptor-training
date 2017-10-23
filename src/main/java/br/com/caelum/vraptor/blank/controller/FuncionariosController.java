package br.com.caelum.vraptor.blank.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.dao.FuncionarioDao;
import br.com.caelum.vraptor.blank.modelo.Funcionario;
import br.com.caelum.vraptor.validator.Validations;

@Resource
@Path("/funcionarios")
public class FuncionariosController {
	
	private FuncionarioDao funcionarioDao;
	private Result result;
	private Validator validator;

	private FuncionariosController(FuncionarioDao funcionarioDao, Result result, Validator validator) {
		this.funcionarioDao = funcionarioDao;
		this.result = result;
		this.validator = validator;
	}	
	
	@Path("cadastro")
	public void form() {
		
	}
	
	@Path({"", "/"})
	public List<Funcionario> lista(Funcionario funcionario){
		result.include("funcionarios", funcionarioDao.searchFuncionarios(funcionario));
		return funcionarioDao.searchFuncionarios(funcionario);
	}
	
	@Post
	@Path("adicionar")
	public void adiciona(Funcionario funcionario) {
		if(funcionarioDao.getFuncionarioByMatricula(funcionario.getMatricula()) != null) {
			validaFuncionario(funcionario);
			funcionarioDao.updateFuncionario(funcionario);
		}else {
			validaFuncionario(funcionario);
			funcionarioDao.insertFuncionario(funcionario);
		}		
		result.redirectTo(FuncionariosController.class).lista(new Funcionario());
	}
	
	@Put
	@Path("atualizar")
	public void atualiza(Funcionario funcionario) {
		if(funcionarioDao.getFuncionarioByMatricula(funcionario.getMatricula()) != null) {
			validaFuncionario(funcionario);
			funcionarioDao.updateFuncionario(funcionario);
		}else {
			validaFuncionario(funcionario);
			funcionarioDao.insertFuncionario(funcionario);
		}		
		result.redirectTo(FuncionariosController.class).lista(new Funcionario());
	}
	
	
	@Delete("deleta/{matricula}")
	public void deleta(int matricula) {
		funcionarioDao.deleteFuncionario(matricula);
		result.redirectTo(this).lista(new Funcionario());
	}
	
	@Get
	@Path("busca")
	public void busca(int matricula) {
		result.include("funcionario", funcionarioDao.getFuncionarioByMatricula(matricula));
		result.redirectTo(this).form();
	}
	
	
	@Path("pesquisa")
	public List<Funcionario> pesquisa(Funcionario funcionario){
		result.include("funcionarios", funcionarioDao.searchFuncionarios(funcionario));
		result.redirectTo(this).lista(funcionario);
		return funcionarioDao.searchFuncionarios(funcionario);
	}
	
	public void validaFuncionario(final Funcionario funcionario) {
		validator.checking(new Validations() { {
			 that(funcionario.getNome() != null, "label label-danger", "nome.vazio");
			 that((funcionario.getDataNascimento() != null), "label label-danger", "dataNascimento.vazia");
			 that(funcionario.getMatricula() != null, "label label-danger", "matricula.invalida");
	        } });
	    validator.onErrorUsePageOf(this).form();
	}
}
