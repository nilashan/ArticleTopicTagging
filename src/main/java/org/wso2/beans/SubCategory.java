package org.wso2.beans;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value="SubCategory")
public class SubCategory {
	private int category_id;
	private int sub_category_id;
	private String sub_category_name;
	/**
	 * @return the category_id
	 */
	public int getCategory_id() {
		return category_id;
	}
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	/**
	 * @return the sub_category_id
	 */
	public int getSub_category_id() {
		return sub_category_id;
	}
	/**
	 * @param sub_category_id the sub_category_id to set
	 */
	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	/**
	 * @return the sub_category_name
	 */
	public String getSub_category_name() {
		return sub_category_name;
	}
	/**
	 * @param sub_category_name the sub_category_name to set
	 */
	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}
}
