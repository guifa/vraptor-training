package br.com.caelum.vraptor.blank.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import br.com.caelum.vraptor.blank.mappers.FuncionarioMapper;
import br.com.caelum.vraptor.blank.model.Funcionario;
import br.com.caelum.vraptor.blank.utils.MyBatisSessionFactory;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class FuncionarioDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public FuncionarioDao() {
		sqlSessionFactory = MyBatisSessionFactory.getSqlSessionFactory();
	}

	public void insertFuncionario(Funcionario funcionario) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
			funcionarioMapper.insertFuncionario(funcionario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Funcionario getFuncionarioByMatricula(Integer matricula) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return funcionarioMapper.getFuncionarioByMatricula(matricula);
		} finally {
			sqlSession.close();
		}
	}

	public List<Funcionario> getAllFuncionarios() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return funcionarioMapper.getAllFuncionarios();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Funcionario> searchFuncionarios(Funcionario funcionario){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
			return funcionarioMapper.searchFuncionarios(funcionario);
		} finally {
			sqlSession.close();
		}
	}

	public void updateFuncionario(Funcionario funcionario) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
			funcionarioMapper.updateFuncionario(funcionario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public void deleteFuncionario(Integer matricula) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
			funcionarioMapper.deleteFuncionario(matricula);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

}
