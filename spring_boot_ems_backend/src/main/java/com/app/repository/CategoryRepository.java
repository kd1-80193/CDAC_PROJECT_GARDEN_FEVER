package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Product;


public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	
}

