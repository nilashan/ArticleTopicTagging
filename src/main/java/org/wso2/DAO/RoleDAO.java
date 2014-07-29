package org.wso2.DAO;

import org.wso2.beans.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
	public void addRole(Role role) throws SQLException{
        String query="INSERT INTO role (role) VALUES('"+role.getRole_id()+"','"+role.getRole()+"')";
        DBConnector.executeQuery(query);
    }
	
	public void updateRole(Role role) throws SQLException{
        String query="UPDATE role SET role='"+role.getRole()+"' WHERE role_id='"+role.getRole_id()+"'";
        DBConnector.executeQuery(query);
    }
	
	public List<Role> getRole() throws SQLException{
		List<Role> list = new ArrayList<Role>();
        String query="SELECT * FROM role";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public static List<Role> getRole(int role_id) throws SQLException{
		List<Role> list = new ArrayList<Role>();
        String query="SELECT * FROM role WHERE role_id='"+role_id+"'";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public void deleteRole(int role_id) throws SQLException{
        String query="DELETE FROM role WHERE role_id='"+role_id+"'";
        DBConnector.executeQuery(query);
    }
	
	protected static Role processSummaryRow(ResultSet rs) throws SQLException {
		Role role= new Role();
		role.setRole_id(rs.getInt("role_id"));
		role.setRole(rs.getString("role"));
		return role;
	}
}