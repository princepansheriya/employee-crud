package com.ignek.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.dao.EmployeeDao;
import com.ignek.model.Employee;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(idParam);

               
                Employee employee = EmployeeDao.getRecordById(employeeId);

                if (employee != null) {
                  
                    request.setAttribute("employee", employee);

                  
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/first.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.getWriter().println("Employee not found.");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid ID parameter.");
            }
        } else {
            response.getWriter().println("ID parameter not provided.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String gender = request.getParameter("gender");

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(idParam);

                
                Employee existingEmployee = EmployeeDao.getRecordById(employeeId);

                if (existingEmployee != null) {
                   
                    existingEmployee.setFirstName(firstName);
                    existingEmployee.setLastName(lastName);
                    existingEmployee.setEmail(email);
                    existingEmployee.setMobileNumber(mobileNumber);
                    existingEmployee.setGender(gender);

                   
                    int updateStatus = EmployeeDao.update(existingEmployee);

                    if (updateStatus > 0) {
                       
                        response.sendRedirect(request.getContextPath() + "/first.jsp");
                    } else {
                        response.getWriter().println("Failed to update employee.");
                    }
                } else {
                    response.getWriter().println("Employee not found.");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid ID parameter.");
            }
        } else {
            response.getWriter().println("ID parameter not provided.");
        }
    }
}
