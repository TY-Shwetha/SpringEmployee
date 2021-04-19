package com.te.springmvcemployee.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvcemployee.bean.EmployeeBean;
import com.te.springmvcemployee.dao.EmployeeDAO;
import com.te.springmvcemployee.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String authenticate(int id,String password,HttpServletRequest request,ModelMap map) {

		EmployeeBean empBean=service.authenticate(id,password);
		if(empBean !=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("emp",empBean);
			return "homepage";
		}else {
			map.addAttribute("errmsg", "Invalid Credentials");

		}
		return "login";
	}

	@GetMapping("/search")
	public String getSearchForm(ModelMap map,HttpSession session) {

		if(session.getAttribute("emp")!=null) {
			return "search";
		}else {
			map.addAttribute("errmsg", "Invalid Credentials");
			return "login";
		}	
	}

	@GetMapping("/search1")
	public String searchEmp(int id,ModelMap map, 
			@SessionAttribute(name="emp",required = false) EmployeeBean empBean) {
		if(empBean !=null) {
			EmployeeBean bean=service.getEmployee(id);
			if(bean !=null) {
				map.addAttribute("data",bean);
			}else {
				map.addAttribute("msg","Data not found:"+id);
			}
			return "search";
		}else {
			map.addAttribute("errmsg","Please Login First");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap map) {
		session.invalidate();
		map.addAttribute("msg","Please Login First");
		return "login";
	}
	
	@GetMapping("/delete")
	public String delete(int id,ModelMap map, 
			@SessionAttribute(name="emp",required = false) EmployeeBean empBean) {
		if(empBean !=null) {
			boolean isDelete=service.deleteEmp(id);
			if(isDelete) {
				map.addAttribute("msg","Deleted Succesfully");
			}else {
				map.addAttribute("errmsg","records not found in db");
			}
			return "delete";
		}else {
			map.addAttribute("msg","Please Login First");
			return "login";
		}
	}
	
	public String getAllEmp() {
		return "";
	}
}
