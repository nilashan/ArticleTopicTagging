package org.wso2.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wso2.beans.Article;

public class ArticleDAO {
	public void addArticle(Article article) throws SQLException{
        System.out.println(article.getAuthor()+article.getTags());
        String query="INSERT INTO article (email,title,url,author,sub_category_id,tags) VALUES('"+article.getEmail()+"','"+article.getTitle()+"','"+article.getUrl()+"','"+article.getAuthor()+"','"+article.getSub_category_id()+"','"+article.getTags()+"')";
        DBConnector.executeQuery(query);
    }
	
	public void updateArticle(Article article) throws SQLException{
        String query="UPDATE article SET author='"+article.getAuthor()+"',email='"+article.getEmail()+"',sub_category_id='"+article.getSub_category_id()+"',tags='"+article.getTags()+"',title='"+article.getTitle()+"',url='"+article.getUrl()+"' WHERE article_id='"+article.getArticle_id()+"'";
        DBConnector.executeQuery(query);
    }
	
	public List<Article> getArticle() throws SQLException{
		List<Article> list = new ArrayList<Article>();
        String query="SELECT * FROM article";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public List<Article> getArticle(int article_id) throws SQLException{
		List<Article> list = new ArrayList<Article>();
        String query="SELECT * FROM article WHERE article_id='"+article_id+"'";
        ResultSet rs =DBConnector.resultsetExecute(query);
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
	    return list;
	}
	
	public void deleteArticle(int article_id) throws SQLException{
        String query="DELETE FROM article WHERE article_id='"+article_id+"'";
        DBConnector.executeQuery(query);
    }
	
	 protected Article processSummaryRow(ResultSet rs) throws SQLException {
		 Article article= new Article();
		 article.setArticle_id(rs.getInt("article_id"));
		 article.setAuthor(rs.getString("author"));
		 article.setEmail(rs.getString("email"));
		 article.setSub_category_id(rs.getInt("sub_category_id"));
		 article.setTags(rs.getString("tags"));
		 article.setTitle(rs.getString("title"));
		 article.setUrl(rs.getString("url"));
		 return article;
	 }
}