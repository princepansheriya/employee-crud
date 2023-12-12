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
import com.ignek.dao.EmployeeDao;
import com.ignek.model.Employee;

@WebServlet("/employeeList")
public class GetAllEmployees extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("GetAllEmployees servlet is called.");

        getServletContext().log("Debug: Test");

        List<Employee> employees = EmployeeDao.getAllRecords();
        ObjectWriter ObjectWrite = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ObjectWrite.writeValueAsString(employees);

        response.setContentType("application/json");
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
