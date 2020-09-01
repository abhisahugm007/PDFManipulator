package com.codeplanet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeplanet.dao.HomeDao;
import com.codeplanet.model.User;
import com.codeplanet.model.UserLogin;
import com.codeplanet.model.UserRegister;

@Service
public class HomeService {
@Autowired
HomeDao homeDao;
	public String insertInfo(UserRegister user,HttpServletResponse res) throws SQLException, IOException {
		
		return homeDao.insertInfo(user,res);
		
	}
	public String getInfo(UserLogin user,HttpServletResponse res) throws IOException {
		
		return homeDao.getInfo(user,res);
	}

}
