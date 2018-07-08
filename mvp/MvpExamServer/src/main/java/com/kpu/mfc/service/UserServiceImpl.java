package com.kpu.mfc.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kpu.mfc.domain.IdVO;
import com.kpu.mfc.persistence.UserDAO;


@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDao;
	
	

	@Override
	public void point(IdVO idVO) throws Exception {
		userDao.point(idVO);
	}



	@Override
	public List<IdVO> loadList() throws Exception {
		// TODO Auto-generated method stub
		return userDao.loadList();
	}



	@Override
	public List<IdVO> find(IdVO id) throws Exception {
		return userDao.find(id);
	}
}
