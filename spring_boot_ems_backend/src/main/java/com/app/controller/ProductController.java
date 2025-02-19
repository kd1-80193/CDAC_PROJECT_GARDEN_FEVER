package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppConstants;
import com.app.dto.ProductDTO;
import com.app.dto.ProductResponse;
import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/create/{catId}")
	@ResponseBody
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product, @PathVariable int catId) {
		ProductDTO createProduct = productService.createProduct(product, catId);
		return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
	}

	// viewProduct
//	@RequestMapping("/viewAll")
//	public ProductResponse viewAllProduct(
//			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER_STRING, required = false) int pageNumber,
//			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE_STRING, required = false) int pageSize,
//			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_STRING, required = false) String sortBy,
//			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_STRING, required = false) String sortDir) {
//		ProductResponse response = productService.viewAll(pageNumber, pageSize, sortBy, sortDir);
//		return response;
//	}

	@RequestMapping("/viewAll")
	public ResponseEntity<List<ProductDTO>> viewAllProduct() {
		List<ProductDTO> viewAll = productService.viewAll();
		return new ResponseEntity<List<ProductDTO>>(viewAll, HttpStatus.ACCEPTED);
	}

	// view productById
	@GetMapping("view/{productId}")
	public ResponseEntity<ProductDTO> viewProductById(@PathVariable int productId) {
		ProductDTO viewProductById = productService.viewProductById(productId);
		return new ResponseEntity<ProductDTO>(viewProductById, HttpStatus.OK);
	}

	// delete productById
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}

	// updateProductById
	@PutMapping("/update/{productId}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable int productId,
			@RequestBody ProductDTO updatedProduct) {
		ProductDTO updated = productService.updateProduct(productId, updatedProduct);
		return new ResponseEntity<ProductDTO>(updated, HttpStatus.ACCEPTED);
	}

	// find product by category

//	@GetMapping("/category/{catId}")
//	public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable int catId, int ResponseEntity) {
//		List<ProductDTO> findProductByCategory = this.productService.findProductByCategory(catId);
//		return new ResponseEntity<List<ProductDTO>>(findProductByCategory, HttpStatus.ACCEPTED);
//	}

	@GetMapping("/products/category/{catId}")
	public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable Integer catId) {
		if (catId == null) {
			// Handle the case when catId is not provided
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<ProductDTO> findProductByCategory = this.productService.findProductByCategory(catId);
		return new ResponseEntity<>(findProductByCategory, HttpStatus.OK);
	}

}
