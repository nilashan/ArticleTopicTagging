package org.wso2.DAO;

import org.wso2.beans.User;
import org.wso2.service.BCrypt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public void addUser(User user) throws SQLException{
		/*MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(user.getPassword().getBytes());
		BigInteger hash = new BigInteger(1, md5.digest());
		String password = hash.toString(16);
		System.out.println(hashed);
		if (BCrypt.checkpw("1234", "$2a$10$oVFYH6TghjvRH9rB74/YoeifYiAurNzbbxQEaE3YAs4jtbgOgPZBi"))*/
		String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String query="INSERT INTO user VALUES('"+user.getEmail()+"','"+password+"','"+user.getFirst_name()+"','"+user.getLast_name()+"','"+user.getRole_id()+"','"+user.getTags()+"','"+user.getDate_of_birth()+"')";
        DBConnector.executeQuery(query);
    }
	
	public void updateUser(User user) throws SQLException{
        String query="UPDATE user SET password='"+user.getPassword()+"',first_name='"+user.getFirst_name()+"',last_name='"+user.getLast_name()+"',role_id='"+user.getRole_id()+"',tags='"+user.getTags()+"',date_of_birth='"+user.getDate_of_birth()+"' WHERE email='"+user.getEmail()+"'";
        DBConnector.executeQuery(query);
    }
	
	public List<User> getUser() throws SQLException{
		List<User> list = new ArrayList<User>();
        String query="SELECT * FROM user";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public static List<User> getUser(String email) throws SQLException{
		List<User> list = new ArrayList<User>();
        String query="SELECT * FROM user WHERE email='"+email+"'";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        } 
	    return list;
	}
	
	public void deleteUser(String email) throws SQLException{
        String query="DELETE FROM user WHERE email='"+email+"'";
        DBConnector.executeQuery(query);
    }
	
	 protected static User processSummaryRow(ResultSet rs) throws SQLException {
		 User user= new User();
		 user.setEmail(rs.getString("email"));
		 user.setPassword(rs.getString("password"));
		 user.setFirst_name(rs.getString("first_name"));
		 user.setLast_name(rs.getString("last_name"));
		 user.setRole_id(rs.getInt("role_id"));
		 user.setTags(rs.getString("tags"));
		 user.setDate_of_birth(rs.getString("date_of_birth"));
		 return user;
	 }
}