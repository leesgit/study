package com.kpu.mfc.service;

import java.util.List;

import com.kpu.mfc.domain.IdVO;



public interface UserService {

	public void point(IdVO idVO) throws Exception;
	public List<IdVO> loadList() throws Exception;
	public List<IdVO> find(IdVO id) throws Exception;
}
