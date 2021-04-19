package com.te.springmvcemployee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.te.springmvcemployee.bean.EmployeeBean;

@Repository
public class EmployeeDAOEmpl implements EmployeeDAO{

	@Override
	public EmployeeBean authenticate(int id,String password) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;

		try {
			factory=Persistence.createEntityManagerFactory("springdb");
			manager=factory.createEntityManager();

			EmployeeBean bean=manager.find(EmployeeBean.class, id);
			if(bean !=null) {
				if(bean.getPassword().equalsIgnoreCase(password)) {
					System.out.println("Login Successfull");
					return bean;
				}else {
					System.out.println("Invalid Password");
					return null;
				}
			}else {
				System.out.println("invalid User");
				return null;
			}

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;

		try {
			factory=Persistence.createEntityManagerFactory("springdb");
			manager=factory.createEntityManager();

			EmployeeBean bean=manager.find(EmployeeBean.class, id);
			if(bean !=null) {
				if(bean.getId().equals(id)) {
					System.out.println("Search Successfull");
					return bean;
				}else {
					System.out.println("Invalid Id");
					return null;
				}
			}else {
				System.out.println("Invalid Id");
				return null;
			}

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
	}
	//Method start
	@Override
	public boolean deleteEmp(int id) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("springdb");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();

			EmployeeBean bean=manager.find(EmployeeBean.class, id);
			if(bean !=null) {
				System.out.println(bean);
				manager.remove(bean);
				transaction.commit();
				System.out.println("Deleted Successfull");
				return true;
			}else {
				System.out.println("Invalid Id");
				return false;
			}

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
	}


	@Override
	public List<EmployeeBean> getAllEmployee() {
		EntityManagerFactory factory=null;
		EntityManager manager=null;


		try {
			factory=Persistence.createEntityManagerFactory("springdb");
			manager=factory.createEntityManager();


			String sql="from EmployeeBean";
			List<EmployeeBean> bean=(List<EmployeeBean>)manager.createQuery(sql);
			if(bean !=null) {
				return bean;
			}else {
				return null;
			}

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
	}
}
