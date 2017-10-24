package br.com.caelum.vraptor.blank.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.caelum.vraptor.blank.modelo.Funcionario;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class DataBaseMemoryFuncionario {

	private static final Set<Funcionario> FUNCIONARIOS = new HashSet<Funcionario>();
	private int count = 1;


	public DataBaseMemoryFuncionario() {
//		carregaExemplos();
	}
	
	public void carregaExemplos() {
		Date atual = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(atual);
		try {
			atual = format.parse(format.format(atual));
			System.out.println(atual);
		} catch (ParseException e) {}
		
		Funcionario f = new Funcionario();
		f.setMatricula(1);
		f.setNome("GUILHERME FERREIRA");
		f.setDataNascimento(atual);
		salva(f);
		
		f = new Funcionario();
		f.setMatricula(2);
		f.setNome("TESTE TESTE");
		f.setDataNascimento(atual);
		salva(f);	
		
		f = new Funcionario();
		f.setMatricula(3);
		f.setNome("AHHHHHH");
		f.setDataNascimento(atual);
		salva(f);	
	}

	public Boolean salva(Funcionario funcionario) {
		return FUNCIONARIOS.add(funcionario);
	}

	public Boolean delete(int matricula) {
		return FUNCIONARIOS.remove(busca(matricula));
	}

	public Boolean atualiza(Funcionario funcionario) {
		FUNCIONARIOS.remove(busca(funcionario.getMatricula()));
		return FUNCIONARIOS.add(funcionario);
	}

	public Boolean contem(Funcionario f) {
		return FUNCIONARIOS.contains(f);
	}

	public Funcionario busca(Integer matricula) {
		for (Funcionario func : FUNCIONARIOS) {
			if (func.getMatricula() == matricula) {
				return func;
			}
		}
		return null;
	}

	public List<Funcionario> pesquisa(Integer matricula, String nome, Date dataNascimento) {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		boolean add = false;
		for (Funcionario func : FUNCIONARIOS) {
			if (matricula != null && func.getMatricula().equals(matricula) || matricula == null)
				add = true;
			else
				add = false;
			if (nome != null && func.getNome().equals(nome) || nome == null && add)
				add = true;
			else
				add = false;
			if (dataNascimento != null && func.getDataNascimento().compareTo(dataNascimento) == 0 || dataNascimento == null && add)
				add = true;
			else
				add = false;
			if (add)
				retorno.add(func);
		}
		return retorno;
	}

	public List<Funcionario> todos() {
		return new ArrayList<Funcionario>(FUNCIONARIOS);
	}
	
}