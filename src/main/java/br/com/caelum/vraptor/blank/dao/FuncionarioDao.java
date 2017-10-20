package br.com.caelum.vraptor.blank.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import br.com.caelum.vraptor.blank.mappers.FuncionarioMapper;
import br.com.caelum.vraptor.blank.modelo.Funcionario;
import br.com.caelum.vraptor.blank.utils.MyBatisSessionFactory;
import br.com.caelum.vraptor.ioc.Component;

public class FuncionarioDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public FuncionarioDao() {
		sqlSessionFactory = MyBatisSessionFactory.getSqlSessionFactory();
	}

	public void insertFuncionario(Funcionario funcionario) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			userMapper.insertFuncionario(funcionario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Funcionario getFuncionarioByMatricula(Integer matricula) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return userMapper.getFuncionarioByMatricula(matricula);
		} finally {
			sqlSession.close();
		}
	}

	public List<Funcionario> getAllFuncionarios() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return userMapper.getAllFuncionarios();
		} finally {
			sqlSession.close();
		}
	}

	public void updateFuncionario(Funcionario funcionario) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			userMapper.updateFuncionario(funcionario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public void deleteFuncionario(Integer matricula) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			userMapper.deleteFuncionario(matricula);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}
	
	public static void main(String[] args) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Date atual = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			atual = format.parse(format.format(atual));
		} catch (ParseException e) {}
		Funcionario funcionario = new Funcionario("Teste", 1, atual);
		
		funcionarioDao.insertFuncionario(funcionario);
	}

}
