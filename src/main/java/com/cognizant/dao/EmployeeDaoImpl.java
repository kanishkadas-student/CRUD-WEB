package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.cognizant.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	
	private static List<Employee> list = new ArrayList<Employee>(
			
			Arrays.asList(
			new Employee(101,"Akash",5000.0),
			new Employee(102,"Aman",6000.0),
			new Employee(103,"Ankana",7000.0),
			new Employee(104,"Ayan",8000.0),
			new Employee(105,"Anuj",9000.0)
					
			)
			);
	public String create(Employee e) {
		if(list.add(e)){
			return "SUCCESS";
		}
		
		return "NOT SUCCESS";
	}

	public String update(Employee e) {
		// TODO Auto-generated method stub
		//boolean dec = list.add(e);
		if(list.add(e)){
			return "SUCCESS";
		}
		
		return "NOT SUCCESS";
	}

	public String delete(Employee e) {
		// TODO Auto-generated method stub
		//boolean dec = list.remove(e);
		if(list.remove(e)){
			return "SUCCESS";
		}
		
		return "NOT SUCCESS";
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return list;
	}

	public Employee getById(int id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		Iterator<Employee> itr = list.iterator();
		while(itr.hasNext()){
			employee = itr.next();
			if(employee.getId()==id)
				return employee;
		}
		
		return null;
	}

}
