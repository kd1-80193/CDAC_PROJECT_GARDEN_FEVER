package com.app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String tittle;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Product> product;  //multiple products can be present in one category hence we use set

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

	public Set<Product> getProduct(Set<Product> product) {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
