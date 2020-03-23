package com.cognizant.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.dao.EmployeeDaoImpl;
import com.cognizant.model.Employee;

public class EmployeeDaoImplTest {
	@Test
	public void testCreate() {
		EmployeeDao dao = new EmployeeDaoImpl();
		String res = dao.create(new Employee(500, "Test", 5000.12));
		assertNotNull(res);
		assertEquals("SUCCESS", res);
	}

	@Test
	public void testUpdate() {
		EmployeeDao dao = new EmployeeDaoImpl();
		String res = dao.update(new Employee(500, "Test", 5000.12));
		assertNotNull(res);
		assertEquals("SUCCESS", res);
	}

	@Test
	public void testDelete() {
		EmployeeDao dao = new EmployeeDaoImpl();
		String res = dao.delete(dao.getById(101));
		assertNotNull(res);
		assertEquals("SUCCESS", res);
	}

	@Test
	public void testGetAll() {
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Employee> list = dao.getAll();
		assertNotNull(list);
	}

}
