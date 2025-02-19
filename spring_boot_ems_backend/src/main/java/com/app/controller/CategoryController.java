package com.app.controller;

import com.app.dto.ApiResponse;
import com.app.dto.CategoryDto;
import com.app.entities.Category;
import com.app.service.CategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private final CategoryService catService;
    private final ModelMapper mapper;
    private CategoryDto create;

    // Constructor injection
    public CategoryController(CategoryService catService, ModelMapper mapper) {
        this.catService = catService;
        this.mapper = mapper;
    }

//    public CategoryController(catService catService) {
//        this.catService = catService;
//    }

	//create category
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto) {
        CategoryDto createCategory = this.catService.create(catDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    //update category
//    @PutMapping("/update/{catId}")
//    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int catId, @RequestBody CategoryDto catDto) {
//        CategoryDto updatedCategory = this.catService.update(catDto, catId);
//        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
//    }
    
    @PutMapping("/update/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int catId, @RequestBody CategoryDto newCat) {
        // Find the existing category or throw ResourceNotFoundException
        Category updatedCategory = this.catService.update(newCat, catId);

        // Convert the updated category to DTO and return it
        CategoryDto updatedCategoryDto = this.mapper.map(updatedCategory, CategoryDto.class);
        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
    }




    //delete by id
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId) {
        this.catService.delete(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }


    //get Category ByID
    @GetMapping("/getById/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {
        CategoryDto getById = this.catService.get(categoryId);
        if (getById != null) {
            return new ResponseEntity<>(getById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // get all 
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> allCategories = this.catService.getAll();
        return new ResponseEntity<List<CategoryDto>>(allCategories, HttpStatus.OK);
    }
}
