package org.wso2.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wso2.beans.SubCategory;

public class SubCategoryDAO {
	public void addSubCategory(SubCategory sub_category) throws SQLException{
        CategoryDAO cdo=new CategoryDAO();
        //String cat=cdo.getCategory(sub_category.getCategory_id());
        String query="INSERT INTO sub_category (category_id,sub_category_name) VALUES('"+sub_category.getCategory_id()+"','"+sub_category.getSub_category_name()+"')";
        DBConnector.executeQuery(query);
    }
	
	public void updateSubCategory(SubCategory sub_category) throws SQLException{
        String query="UPDATE sub_category SET category_id='"+sub_category.getCategory_id()+"',sub_category_name='"+sub_category.getSub_category_name()+"' WHERE sub_category_id='"+sub_category.getSub_category_id()+"'";
        DBConnector.executeQuery(query);
    }
	
	public List<SubCategory> getSubCategory() throws SQLException{
		List<SubCategory> list = new ArrayList<SubCategory>();
        String query="SELECT * FROM sub_category";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public List<SubCategory> getSubCategory(int sub_category_id) throws SQLException{
		List<SubCategory> list = new ArrayList<SubCategory>();
        String query="SELECT * FROM sub_category WHERE sub_category_id='"+sub_category_id+"'";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public void deleteSubCategory(int sub_category_id) throws SQLException{
        String query="DELETE FROM sub_category WHERE sub_category_id='"+sub_category_id+"'";
        DBConnector.executeQuery(query);
    }
	
	 protected SubCategory processSummaryRow(ResultSet rs) throws SQLException {
		 SubCategory sub_category= new SubCategory();
		 sub_category.setSub_category_id(rs.getInt("sub_category_id"));
		 sub_category.setCategory_id(rs.getInt("category_id"));
		 sub_category.setSub_category_name(rs.getString("sub_category_name"));
		 return sub_category;
	 }
}
