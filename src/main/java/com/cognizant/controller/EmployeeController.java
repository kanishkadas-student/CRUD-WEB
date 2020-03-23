package com.cognizant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.dao.EmployeeDaoImpl;
import com.cognizant.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao dao = new EmployeeDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		// Read The Request Parameter
		String action = request.getParameter("action");
		System.out.println("Action: " + action);

		if (action.equals("insert")) {
			insert(request, response);
		} else if (action.equals("update")) {
			update(request, response);
		} else if (action.equals("delete")) {
			delete(request, response);
		} else if (action.equals("getAll")) {
			getAll(request, response);
		} else {
			// Process The request
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Invoking Dao
		List<Employee> list = dao.getAll();
		System.out.println(list);
		//Dispatch The request to show.jsp
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		//Add the data/Attribute to the request
		request.setAttribute("List", list);
		//Forward the request
		rd.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		String str =dao.delete(dao.getById(id));
		RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		if(str.equals("SUCCESS")){
			request.setAttribute("msg","record deleted successfully");
		} else{
			request.setAttribute("msg", "Record deletion Fail");
		}
		rd.forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		String str =dao.update(new Employee(id,name,salary));
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		if(str.equals("SUCCESS")){
			request.setAttribute("msg","record updateded successfully");
		} else{
			request.setAttribute("msg", "Record updation Fail");
		}
		rd.forward(request, response);

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//List<Employee> list = dao.create(e);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		String str =dao.create(new Employee(id,name,salary));
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		if(str.equals("SUCCESS")){
			request.setAttribute("msg","record inserted successfully");
		} else{
			request.setAttribute("msg", "Record Inserton Fail");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
