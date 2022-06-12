package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String columnValue;
	public String getDataFromDb(String columnName) throws SQLException {
		
		//set the properties of mySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Go to google "mySQLdriver" get the link. 
			//connecting SQL url
			String sqlUrl = "jdbc:mysql://localhost:3306/cucumber";
			String sqlUsername = "root";
			String sqlPassword = "root";
			String sqlQuery = "select * from test_data;";
			//these 3 are interfaces
			
			//create a connection to local database
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			
			//Empower the connection reference variable to execute queries
			statement = connection.createStatement();
			
			//Deliver the query
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
			return columnValue = resultSet.getNString(columnName);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(connection != null) {
				connection.close();
			}
		}
		
		return columnValue;
		
	}
}
