package org.wso2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {
	private static Connection con;
 
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String queryStr="jdbc:mysql://mysql-dev-01.cloud.wso2.com:3306/article_projectwso2";
            con=DriverManager.getConnection(queryStr,"article_7BjICuwY","dbuser");
        } catch (Exception ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void executeQuery(String query) throws SQLException{
    	getConnection();
    	Statement stmt=null;
    	try {
    		stmt=con.createStatement();
    		stmt.execute(query);
    		System.out.println("Query executed successfully!");
		} 
    	catch (Exception ex) {
    		System.out.println("Error in executing query!");
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    	stmt.close();
    	con.close();
    }
    
    public static ResultSet resultsetExecute(String query) throws SQLException{
    	getConnection();
    	Statement stmt=null;
    	ResultSet resultset=null;
    	try {
    		stmt=con.createStatement();
    		resultset=stmt.executeQuery(query);
    		System.out.println("Query executed successfully!");
		} 
    	catch (Exception ex) {
    		System.out.println("Error in executing query!");
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
		return resultset;
    }
}
