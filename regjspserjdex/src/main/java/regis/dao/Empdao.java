package regis.dao;

import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import regismodel.Employee;

public class Empdao {
	public int registerEmployee(final Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +" (id, first_name, last_name, username, password, address, contact) VALUES"+"(?, ?, ?, ?, ?,?,?);";;
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "8331");
          
        		
        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL));
        		
                        preparedStatement.setInt(1, 1);
                        preparedStatement.setString(2, employee.getFirstName());
                        preparedStatement.setString(3, employee.getLastName());
                        preparedStatement.setString(4, employee.getUsername());
                        preparedStatement.setString(5, employee.getPassword());
                        preparedStatement.setString(6, employee.getAddress());
                        preparedStatement.setString(7, employee.getContact());
        		
                        System.out.println(preparedStatement);
        		
                        result = preparedStatement.executeUpdate();
                    }catch((Exception e)
	{
           e.printStackTrace();
           }
              result=0;return result;
}
