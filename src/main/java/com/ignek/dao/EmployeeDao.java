package com.ignek.dao;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ignek.constant.EmployeeConstant;
import com.ignek.model.Employee;
	
	public class EmployeeDao {
		 public static Connection getConnection() {
		        Connection connection = null;
		        try {
		            Class.forName(EmployeeConstant.JDBC_DRIVER);
		            connection = DriverManager.getConnection(EmployeeConstant.JDBC_URL, EmployeeConstant.DB_USER, EmployeeConstant.DB_PASSWORD);
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		        return connection;
		    }
	
		public static int save(Employee u) {
			int status = 0;
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(EmployeeConstant.INSERT_EMPLOYEE);
				preparedStatement.setString(1, u.getFirstName());
				preparedStatement.setString(2, u.getLastName());
				preparedStatement.setString(3, u.getEmail());
				preparedStatement.setString(4, u.getMobileNumber());
				preparedStatement.setString(5, u.getGender());
				status = preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			return status;
		}
	
		public static List<Employee> getAllRecords(String searchTerm) {
		    List<Employee> list = new ArrayList<>();

		    try {
		        Connection connection = getConnection();
		        String query;

		        if (searchTerm != null && !searchTerm.isEmpty()) {
		            query = "SELECT * FROM employee " +
		                    "WHERE id LIKE ? OR " +
		                    "firstName LIKE ? OR " +
		                    "lastName LIKE ? OR " +
		                    "email LIKE ? OR " +
		                    "mobileNumber LIKE ? OR " +
		                    "gender LIKE ?";
		        } else {
		            query = "SELECT * FROM employee";
		        }

		        PreparedStatement ps = connection.prepareStatement(query);

		        if (searchTerm != null && !searchTerm.isEmpty()) {
		            for (int i = 1; i <= 6; i++) {
		                ps.setString(i, "%" + searchTerm + "%");
		            }
		        }

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Employee user = new Employee();
		            user.setId(rs.getInt(EmployeeConstant.ID));
		            user.setFirstName(rs.getString(EmployeeConstant.FIRST_NAME));
		            user.setLastName(rs.getString(EmployeeConstant.LAST_NAME));
		            user.setEmail(rs.getString(EmployeeConstant.EMAIL));
		            user.setMobileNumber(rs.getString(EmployeeConstant.MOBILE_NUMBER));
		            user.setGender(rs.getString(EmployeeConstant.GENDER));

		            list.add(user);
		        }
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		    return list;
		}

		public static int delete(int id) {
		    int status = 0;
		    try {
		        Connection connection = getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstant.DELETE_EMPLOYEE_BY_ID );
		        preparedStatement.setInt(1, id);
		        status = preparedStatement.executeUpdate();
		    } catch (Exception e) {
		        System.out.println(e);
		    }
	
		    return status;
		}
	
	
		
		public static Employee getRecordById(int id) {
			Employee employe= null;
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstant.SELECT_EMPLOYEE_BY_ID);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					employe = new Employee();
					employe.setId(rs.getInt(EmployeeConstant.ID));
					employe.setFirstName(rs.getString(EmployeeConstant.FIRST_NAME));
					employe.setLastName(rs.getString(EmployeeConstant.LAST_NAME));
					employe.setEmail(rs.getString(EmployeeConstant.EMAIL));
					employe.setMobileNumber(rs.getString(EmployeeConstant.MOBILE_NUMBER));
					employe.setGender(rs.getString(EmployeeConstant.GENDER));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return employe;
		}
		
		public static int update(Employee employe) {
		    int status = 0;
		    try {
		        Connection connection = getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstant.UPDATE_EMPLOYEE);
		        preparedStatement.setString(1, employe.getFirstName());
		        preparedStatement.setString(2, employe.getLastName());
		        preparedStatement.setString(3, employe.getEmail());
		        preparedStatement.setString(4, employe.getMobileNumber());
		        preparedStatement.setString(5, employe.getGender());
		        preparedStatement.setInt(6, employe.getId());
	
		        status = preparedStatement.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return status;
		}
		
	
	}
