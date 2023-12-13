package com.ignek.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ignek.constant.EmployeeConstant;
import com.ignek.dao.EmployeeDao;
import com.ignek.model.Employee;

@WebServlet("/employeeList")
public class GetAllEmployees extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        

        getServletContext().log(EmployeeConstant.DEBUG_TEST);

        String searchTerm = request.getParameter(EmployeeConstant.SEARCH_TERM);
        List<Employee> employees = EmployeeDao.getAllRecords(searchTerm);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(employees);
        

        response.setContentType(EmployeeConstant.APPLICATION_JSON);
        response.setCharacterEncoding(EmployeeConstant.UTF_8);
        response.getWriter().write(json);
    }

}

