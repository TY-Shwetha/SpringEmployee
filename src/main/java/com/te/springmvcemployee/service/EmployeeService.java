package com.te.springmvcemployee.service;

import java.util.List;

import com.te.springmvcemployee.bean.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean authenticate(int id,String password);

	public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmp(int id);
	
	public List<EmployeeBean> getAllEmployee();
}
