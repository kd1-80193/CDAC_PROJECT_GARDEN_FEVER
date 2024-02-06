package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String tittle;
	public Category() {
		super();
	}
	public Category(int categoryId, String tittle) {
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
		return "Category [categoryId=" + categoryId + ", tittle=" + tittle + "]";
	}
	
	
	
}
