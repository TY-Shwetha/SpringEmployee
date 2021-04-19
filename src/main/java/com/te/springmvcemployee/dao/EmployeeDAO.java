package com.te.springmvcemployee.dao;

import java.util.List;

import com.te.springmvcemployee.bean.EmployeeBean;

public interface EmployeeDAO {

	public EmployeeBean authenticate(int id,String password);

	public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmp(int id);
	
	public List<EmployeeBean> getAllEmployee();
}
