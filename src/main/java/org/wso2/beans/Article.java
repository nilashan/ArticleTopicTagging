package org.wso2.beans;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value="Article")
public class Article {
	private int article_id;
	private String email;
	private String title;    
	private String url;
	private String author;
	private int sub_category_id;
	private String tags;
	/**
	 * @return the article_id
	 */
	public int getArticle_id() {
		return article_id;
	}
	/**
	 * @param article_id the article_id to set
	 */
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the subCategoryId
	 */
	public int getSub_category_id() {
		return sub_category_id;
	}
	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
}
