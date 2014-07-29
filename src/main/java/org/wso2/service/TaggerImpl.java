package org.wso2.service;

import org.jboss.resteasy.util.Base64;
import org.wso2.DAO.*;
import org.wso2.beans.*;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

public class TaggerImpl implements Tagger {

    public List<User> loginUser(String username) throws SQLException {

        String []ss=username.split("\\s+");
        String s1=ss[1];
        String up=null;
        try {
            up= new String(Base64.decode(s1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final StringTokenizer tokenizer = new StringTokenizer(up, ":");
        final String email = tokenizer.nextToken();
        System.out.println(email);
        UserDAO userDAO = new UserDAO();
        List<User> list = null;
        list = userDAO.getUser(email);
        return list;
    }

    // for user
	public Response addUser(User user) throws SQLException{
		UserDAO userDAO = new UserDAO();
		userDAO.addUser(user);
		return null;
	}

	public Response updateUser(User user) throws SQLException {
		UserDAO userDAO = new UserDAO();
		userDAO.updateUser(user);
		return null;
	}

	public List<User> getUser() throws SQLException {
		UserDAO userDAO = new UserDAO();
		List<User> list = null;
		list = userDAO.getUser();
		return list;
	}

	public List<User> getUser(String email) throws SQLException {
		UserDAO userDAO = new UserDAO();
		List<User> list = null;
		list = userDAO.getUser(email);
		return list;
	}

	public Response deleteUser(String email) throws SQLException {
		UserDAO userDAO = new UserDAO();
		userDAO.deleteUser(email);
		return null;
	}

	// for article
	public Response addArticle(Article article) throws SQLException {
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.addArticle(article);
		return null;
	}

	public Response updateArticle(Article article) throws SQLException {
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.updateArticle(article);
		return null;
	}

	public List<Article> getArticle() throws SQLException {
		ArticleDAO articleDAO = new ArticleDAO();
		List<Article> list = null;
		list = articleDAO.getArticle();
		return list;
	}

	public List<Article> getArticle(int article_id) throws SQLException {
		ArticleDAO articleDAO = new ArticleDAO();
		List<Article> list = null;
		list = articleDAO.getArticle(article_id);
		return list;
	}

	public Response deleteArticle(int article_id) throws SQLException {
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.deleteArticle(article_id);
		return null;
	}

	// for role
	public Response addRole(Role role) throws SQLException {
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.addRole(role);
		return null;
	}

	public Response updateRole(Role role) throws SQLException {
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.updateRole(role);
		return null;
	}

	public List<Role> getRole() throws SQLException {
		RoleDAO roleDAO = new RoleDAO();
		List<Role> list = null;
		list = roleDAO.getRole();
		return list;
	}

	public List<Role> getRole(int role_id) throws SQLException {
		RoleDAO roleDAO = new RoleDAO();
		List<Role> list = null;
		list = roleDAO.getRole(role_id);
		return list;
	}

	public Response deleteRole(int role_id) throws SQLException {
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.deleteRole(role_id);
		return null;
	}

	// for category
	public Response addCategory(Category category) throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.addCategory(category);
		return null;
	}

	public Response updateCategory(Category category) throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.updateCategory(category);
		return null;
	}

	public List<Category> getCategory() throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> list = null;
		list = categoryDAO.getCategory();
		return list;
	}

	public List<Category> getCategory(int category_id) throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> list = null;
		list = categoryDAO.getCategory(category_id);
		return list;
	}

	public Response deleteCategory(int category_id) throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.deleteCategory(category_id);
		return null;
	}

	// for sub_category
	public Response addSubCategory(SubCategory sub_category)
			throws SQLException {
		SubCategoryDAO sub_categoryDAO = new SubCategoryDAO();
		sub_categoryDAO.addSubCategory(sub_category);
		return null;
	}

	public Response updateSubCategory(SubCategory sub_category)
			throws SQLException {
		SubCategoryDAO sub_categoryDAO = new SubCategoryDAO();
		sub_categoryDAO.updateSubCategory(sub_category);
		return null;
	}

	public List<SubCategory> getSubCategory() throws SQLException {
		SubCategoryDAO sub_categoryDAO = new SubCategoryDAO();
		List<SubCategory> list = null;
		list = sub_categoryDAO.getSubCategory();
		return list;
	}

	public List<SubCategory> getSubCategory(int sub_category_id)
			throws SQLException {
		SubCategoryDAO sub_categoryDAO = new SubCategoryDAO();
		List<SubCategory> list = null;
		list = sub_categoryDAO.getSubCategory(sub_category_id);
		return list;
	}

	public Response deleteSubCategory(int sub_category_id) throws SQLException {
		SubCategoryDAO sub_categoryDAO = new SubCategoryDAO();
		sub_categoryDAO.deleteSubCategory(sub_category_id);
		return null;
	}
}