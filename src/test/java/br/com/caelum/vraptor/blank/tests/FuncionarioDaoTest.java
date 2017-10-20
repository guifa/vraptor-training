package br.com.caelum.vraptor.blank.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.vraptor.blank.dao.FuncionarioDao;
import br.com.caelum.vraptor.blank.modelo.Funcionario;

public class FuncionarioDaoTest {
	private static FuncionarioDao funcionarioDao;
	private static Logger logger;

	@BeforeClass
	public static void setup() {
		System.setProperty("log4j.configurationFile","log4j-testConfig.xml");
		logger = LogManager.getLogger(FuncionarioDaoTest.class);
		funcionarioDao = new FuncionarioDao();
	}

	@AfterClass
	public static void teardown() {
		funcionarioDao = null;
	}

	@Test
	public void testGetFuncionarioByMatricula() {
		Funcionario funcionario = funcionarioDao.getFuncionarioByMatricula(1);
		Assert.assertNotNull(funcionario);
		System.out.println(funcionario.getNome());
	}

	@Test
	public void testGetAllFuncionarios() {
		List<Funcionario> funcionarios = funcionarioDao.getAllFuncionarios();
		Assert.assertNotNull(funcionarios);
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}
	}

	@Test
    public void testInsertFuncionario() {
		Funcionario funcionario = new Funcionario();
		Date atual = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(atual);
		try {
			atual = format.parse(format.format(atual));
		} catch (ParseException e) {}
		
		funcionario.setMatricula(2);
		funcionario.setNome("Test Tests");
		funcionario.setDataNascimento(atual);


		funcionarioDao.insertFuncionario(funcionario);
		Assert.assertTrue(funcionario.getMatricula() != 0);
		Funcionario createdFuncionario = funcionarioDao.getFuncionarioByMatricula(funcionario.getMatricula());
		Assert.assertNotNull(createdFuncionario);
		Assert.assertEquals(funcionario.getMatricula(), createdFuncionario.getMatricula());
		Assert.assertEquals(funcionario.getNome(), createdFuncionario.getNome());
		Assert.assertEquals(funcionario.getDataNascimento(), createdFuncionario.getDataNascimento());

	}

	@Test
    public void testUpdateFuncionario()  {
		long timestamp = System.currentTimeMillis();
		Funcionario funcionario = funcionarioDao.getFuncionarioByMatricula(1);
		funcionario.setNome("Test Tests" + timestamp);
		funcionarioDao.updateFuncionario(funcionario);
		
		Funcionario updatedFuncionario = funcionarioDao.getFuncionarioByMatricula(1);
		Assert.assertEquals(funcionario.getNome(), updatedFuncionario.getNome());
	}

	@Test
	public void testDeleteFuncionario() {
		Funcionario funcionario = funcionarioDao.getFuncionarioByMatricula(1);
		funcionarioDao.deleteFuncionario(funcionario.getMatricula());
		Funcionario deletedFuncionario = funcionarioDao.getFuncionarioByMatricula(1);
		Assert.assertNull(deletedFuncionario);

	}
}
