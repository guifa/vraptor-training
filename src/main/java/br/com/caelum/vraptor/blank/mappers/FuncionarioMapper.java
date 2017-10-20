package br.com.caelum.vraptor.blank.mappers;

import java.util.List;

import br.com.caelum.vraptor.blank.modelo.Funcionario;

public interface FuncionarioMapper {
	
	public void insertFuncionario(Funcionario funcionario);
	
	public Funcionario getFuncionarioByMatricula(Integer matricula);
	
	public List<Funcionario> getAllFuncionarios();
	
	public void updateFuncionario(Funcionario funcionario);
	
	public void deleteFuncionario(Integer matricula);

}
