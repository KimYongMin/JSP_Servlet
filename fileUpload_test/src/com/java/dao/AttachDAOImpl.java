package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.java.dataSource.MybatisDataSource;
import com.java.dto.AttachVO;

public class AttachDAOImpl implements AttachDAO{
	
	private static AttachDAOImpl instance=new AttachDAOImpl();
	private AttachDAOImpl(){}
	public static AttachDAOImpl getInstance() {
		return instance;
	}
	
	@Override
	public void insertAttach(AttachVO attach) throws SQLException {
		SqlSession session = MybatisDataSource.getInstance().getSqlSession(true);
		session.update("Attach-Mapper.insertAttach",attach);
		session.close();		
	}

	@Override
	public void deleteAttach(int ano) throws SQLException {
		SqlSession session = MybatisDataSource.getInstance().getSqlSession(true);
		session.update("Attach-Mapper.deleteAttach",ano);		
		session.close();
		
	}

	@Override
	public List<AttachVO> selectAttachesByPno(int pno) throws SQLException {
		SqlSession session = MybatisDataSource.getInstance().getSqlSession();
		List<AttachVO> attachList=
				session.selectList("Attach-Mapper.selectAttachByPno",pno);
		session.close();
		return attachList;
	}

	@Override
	public void deleteAllAttach(int pno) throws SQLException {
		SqlSession session = MybatisDataSource.getInstance().getSqlSession(true);
		session.update("Attach-Mapper.deleteAllAttach",pno);		
		session.close();		
	}
	@Override
	public AttachVO selectAttachByAno(int ano) throws SQLException {
		SqlSession session = MybatisDataSource.getInstance().getSqlSession(true);
		
		AttachVO attach=
			session.selectOne("Attach-Mapper.selectAttachByAno",ano);
		
		session.close();
		return attach;
	}

}
