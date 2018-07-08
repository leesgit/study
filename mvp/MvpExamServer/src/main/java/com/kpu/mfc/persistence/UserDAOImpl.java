package com.kpu.mfc.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kpu.mfc.domain.IdVO;


@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.CMapper";
	
	



	@Override
	public void point(IdVO idVO) throws Exception {
		session.insert(namespace+".point", idVO);
	}


	@Override
	public List<IdVO> loadList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".loadList");
	}


	@Override
	public List<IdVO> find(IdVO id) throws Exception {
		try {
			return session.selectList(namespace+".find", id);
		}catch(NullPointerException e) {
			return new ArrayList<>();
		}catch(Exception e) {
			throw e;
		}
	}
}
