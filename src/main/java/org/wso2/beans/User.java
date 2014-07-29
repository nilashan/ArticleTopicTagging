package org.wso2.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class User {
	private String email;
	private String password;
	private String first_name;    
	private String last_name;
	private int role_id;
	private String tags;
	private String date_of_birth;
	/**
	 * @return the user_name
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param string the user_name to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param string the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * @return the date_of_birth
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}
	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
}