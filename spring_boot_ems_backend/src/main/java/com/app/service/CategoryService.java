package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CategoryDto;
import com.app.entities.Category;
import com.app.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ModelMapper mapper;
	
	public CategoryDto create(CategoryDto dto) {
		Category cat=this.mapper.map(dto, Category.class);
		Category save = this.catRepo.save(cat);
		
		//category to categoryDto
		return this.mapper.map(save, CategoryDto.class);
	}
	
	public Category update(CategoryDto newCat, int catId) {
	    Category oldCat = this.catRepo.findById(catId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + catId));

	    // Update the fields of the existingCategory with values from the DTO
	    oldCat.setTittle(newCat.getTittle());

	    // Save the updated category
	    return this.catRepo.save(oldCat);
	}

	
	public void delete(int catId) {
	    Category cat = this.catRepo.findById(catId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + catId));
	    this.catRepo.delete(cat);
	}

	
	public CategoryDto get(int catId) {
	    Category getById = this.catRepo.findById(catId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + catId));

	    return this.mapper.map(getById, CategoryDto.class);
	}

	
	public List<CategoryDto> getAll() {
		List<Category>findAll=this.catRepo.findAll();
		List<CategoryDto>allDto=findAll.stream().map(cat->this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return allDto;
	}
	
}
