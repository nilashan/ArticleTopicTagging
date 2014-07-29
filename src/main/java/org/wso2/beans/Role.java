package org.wso2.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Role")
public class Role {
	private int role_id;
	private String role;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}
