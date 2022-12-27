/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 22, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.dto;

public class ProductSearch {

	public String name;
	public String title;
	public String keyWord;
	public Integer categoryId;
	public Integer currentPage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
