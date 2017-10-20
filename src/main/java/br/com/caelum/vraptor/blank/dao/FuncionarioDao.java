package br.com.caelum.vraptor.blank.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import br.com.caelum.vraptor.blank.mappers.FuncionarioMapper;
import br.com.caelum.vraptor.blank.modelo.Funcionario;
import br.com.caelum.vraptor.blank.utils.MyBatisSessionFactory;

public class FuncionarioDao {

	public void insertFuncionario(Funcionario funcionario) {
		SqlSession sqlSession = MyBatisSessionFactory.getSqlSessionFactory().openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			userMapper.insertFuncionario(funcionario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Funcionario getFuncionarioByMatricula(Integer matricula) {
		SqlSession sqlSession = MyBatisSessionFactory.getSqlSessionFactory().openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return userMapper.getFuncionarioByMatricula(matricula);
		} finally {
			sqlSession.close();
		}
	}

	public List<Funcionario> getAllFuncionarios() {
		SqlSession sqlSession = MyBatisSessionFactory.getSqlSessionFactory().openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return userMapper.getAllFuncionarios();
		} finally {
			sqlSession.close();
		}
	}

	public void updateFuncionario(Funcionario funcionario) {
		SqlSession sqlSession = MyBatisSessionFactory.getSqlSessionFactory().openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			userMapper.updateFuncionario(funcionario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public void deleteFuncionario(Integer matricula) {
		SqlSession sqlSession = MyBatisSessionFactory.getSqlSessionFactory().openSession();
		try {
			FuncionarioMapper userMapper = sqlSession.getMapper(FuncionarioMapper.class);
			userMapper.deleteFuncionario(matricula);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

}
