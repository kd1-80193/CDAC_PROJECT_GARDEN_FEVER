package com.app.dto;

public class CategoryDto {

	private int categoryId;
	private String tittle;

	public CategoryDto() {
		super();
	}

	public CategoryDto(int categoryId, String tittle) {
		super();
		this.categoryId = categoryId;
		this.tittle = tittle;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", tittle=" + tittle + "]";
	}

}
