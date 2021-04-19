package com.te.springmvcemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvcemployee.bean.EmployeeBean;
import com.te.springmvcemployee.dao.EmployeeDAO;

@Service
public class EmployeeServiceEmpl implements EmployeeService{

	@Autowired
	EmployeeDAO dao;
	
	@Override
	public EmployeeBean authenticate(int id, String password) {
		
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmp(int id) {
		
		return dao.deleteEmp(id);
	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}
	

}
