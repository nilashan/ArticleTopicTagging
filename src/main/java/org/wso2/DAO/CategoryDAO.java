package org.wso2.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wso2.beans.Category;;

public class CategoryDAO {
	public void addCategory(Category category) throws SQLException{
        String query="INSERT INTO category (category_name) VALUES('"+category.getCategory_name()+"')";
        DBConnector.executeQuery(query);
    }
	
	public void updateCategory(Category category) throws SQLException{
        String query="UPDATE category SET category_name='"+category.getCategory_name()+"' WHERE category_id='"+category.getCategory_id()+"'";
        DBConnector.executeQuery(query);
    }
	
	public List<Category> getCategory() throws SQLException{
		List<Category> list = new ArrayList<Category>();
        String query="SELECT * FROM category";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        } 
	    return list;
	}
	
	public List<Category> getCategory(int category_id) throws SQLException{
		List<Category> list = new ArrayList<Category>();
        String query="SELECT * FROM category WHERE category_id='"+category_id+"'";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public void deleteCategory(int category_id) throws SQLException{
        String query="DELETE FROM category WHERE category_id='"+category_id+"'";
        DBConnector.executeQuery(query);
    }
	
	 protected Category processSummaryRow(ResultSet rs) throws SQLException {
		 Category category= new Category();
		 category.setCategory_id(rs.getInt("category_id"));
		 category.setCategory_name(rs.getString("category_name"));
		 return category;
	 }
}