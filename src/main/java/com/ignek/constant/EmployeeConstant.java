package com.ignek.constant;

public class EmployeeConstant {
	
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/ignek";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "prince2141";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	
	
	public static final String ERROR_DELETE_EMPLOYEE = "Error deleting employee record.";
    public static final String ERROR_INVALID_ID = "Invalid ID parameter.";
    public static final String ERROR_MISSING_ID = "ID parameter not provided.";
    public static final String ERROR_SAVE_EMPLOYEE = "Error saving employee details.";
    
    
    
    public static final String INSERT_EMPLOYEE = "INSERT INTO employee (firstName, lastName, email, mobileNumber, gender) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    public static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE id=?";
    public static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id=?";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName=?, lastName=?, email=?, mobileNumber=?, gender=? WHERE id=?";

    
    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String GENDER = "gender";
}
