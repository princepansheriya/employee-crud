package com.ignek.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.constant.EmployeeConstant;
import com.ignek.dao.EmployeeDao;
import com.ignek.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter(EmployeeConstant.ID);

		int userId = 0;
		if (!(idParam.isEmpty() || idParam.isBlank())) {
			userId = Integer.parseInt(idParam);
		}

		String firstName = request.getParameter(EmployeeConstant.FIRST_NAME);
		String lastName = request.getParameter(EmployeeConstant.LAST_NAME);
		String email = request.getParameter(EmployeeConstant.EMAIL);
		String mobileNumber = request.getParameter(EmployeeConstant.MOBILE_NUMBER);
		String gender = request.getParameter(EmployeeConstant.GENDER);

		Employee employee = new Employee(userId, firstName, lastName, email, mobileNumber, gender);
		int status = 0;
		if (userId > 0) {
			status = EmployeeDao.update(employee);

		} else {
			status = EmployeeDao.save(employee);

		}

		if (status > 0) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/first.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().println(EmployeeConstant.ERROR_SAVE_EMPLOYEE);
		}
	}
}
