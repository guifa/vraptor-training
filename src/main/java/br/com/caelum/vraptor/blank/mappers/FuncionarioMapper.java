package br.com.caelum.vraptor.blank.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.blank.modelo.Funcionario;

@Component
public interface FuncionarioMapper {
	
	public void insertFuncionario(Funcionario funcionario);
	
	public Funcionario getFuncionarioByMatricula(Integer matricula);
	
	public List<Funcionario> getAllFuncionarios();
	
	public List<Funcionario> searchFuncionarios(Funcionario funcionario);
	
	public void updateFuncionario(Funcionario funcionario);
	
	public void deleteFuncionario(Integer matricula);

}
