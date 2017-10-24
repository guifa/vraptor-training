package br.com.caelum.vraptor.blank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.blank.mappers.FuncionarioMapper;
import br.com.caelum.vraptor.blank.modelo.Funcionario;

@Service
@Transactional
public class FuncionarioService {
	
	@Autowired
	private FuncionarioMapper funcionarioMapper;
	
	public void insertFuncionario(Funcionario funcionario) {
		funcionarioMapper.insertFuncionario(funcionario);
	}
	
	public Funcionario getFuncionarioByMatricula(Integer matricula) {
		return funcionarioMapper.getFuncionarioByMatricula(matricula);
	}
	
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioMapper.getAllFuncionarios();
	}
	
	public List<Funcionario> searchFuncionarios(Funcionario funcionario) {
		return funcionarioMapper.searchFuncionarios(funcionario);
	}
	
	public void updateFuncionario(Funcionario funcionario) {
		funcionarioMapper.updateFuncionario(funcionario);
	}
	
	public void deleteFuncionario(Integer matricula) {
		funcionarioMapper.deleteFuncionario(matricula);
	}
}
