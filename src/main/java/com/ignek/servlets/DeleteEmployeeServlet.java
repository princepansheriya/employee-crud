package com.ignek.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.constant.EmployeeConstant;
import com.ignek.dao.EmployeeDao;

@WebServlet("/deleteUser")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");

		if (idParam != null && !idParam.isEmpty()) {
			try {
				int employeeId = Integer.parseInt(idParam);

				int status = EmployeeDao.delete(employeeId);

				if (status > 0) {
					response.sendRedirect(request.getContextPath() + "/first.jsp");
				} else {
					response.getWriter().println(EmployeeConstant.ERROR_DELETE_EMPLOYEE);
				}
			} catch (NumberFormatException e) {
				response.getWriter().println(EmployeeConstant.ERROR_INVALID_ID);
			}
		} else {
			response.getWriter().println(EmployeeConstant.ERROR_MISSING_ID);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
