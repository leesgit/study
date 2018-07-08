package com.kpu.mfc.controller;

import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpu.mfc.domain.IdVO;
import com.kpu.mfc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	UserService service;
	
	
	@PostMapping("/point")
	public void point(@RequestBody IdVO vo) throws Exception {
		service.point(vo);	
	}
	
	@GetMapping("/point/list")
	public ResponseEntity<List<IdVO>> listAll() {
		ResponseEntity<List<IdVO>> entity = null;
		List<IdVO> list = null;
		
		try {
			list = service.loadList();
			entity = new ResponseEntity<List<IdVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<IdVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@PostMapping("/find")
	public ResponseEntity<List<IdVO>> find(@RequestBody IdVO id) {
		ResponseEntity<List<IdVO>> entity = null;
		List<IdVO> list = null;
		
		try {
			list = service.find(id);
			entity = new ResponseEntity<List<IdVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<IdVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
}
	
	
	
	
	
	
	
