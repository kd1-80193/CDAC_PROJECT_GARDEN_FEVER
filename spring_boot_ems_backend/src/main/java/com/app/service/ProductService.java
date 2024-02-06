package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ProductDTO;
import com.app.entities.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;

	public ProductDTO createProduct(ProductDTO product) {

		// productdto to product
		Product entity = toEntity(product);
		Product save = productRepo.save(entity);

		// product to productdto
		ProductDTO dto = toDTO(save);

		return dto;
	}

	public List<ProductDTO> viewAll() {
		List<Product> findAll = productRepo.findAll();

		// Using Java Stream to convert each Product to ProductDTO
		List<ProductDTO> findAllDto = findAll.stream().map(product -> this.toDTO(product)).collect(Collectors.toList());

		return findAllDto;
	}

	public ProductDTO viewProductById(int productId) {
		Product findById = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("id " + productId + " not found"));
		ProductDTO dto = this.toDTO(findById);
		return dto;
	}

	public void deleteProduct(int productId) {

		Product byId = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("id " + productId + " not found"));
		;
		productRepo.deleteById(productId);
	}

	public ProductDTO updateProduct(int productId, ProductDTO updatedProduct) {
		Product existingProduct = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("id " + productId + " not found"));

		existingProduct.setProduct_name(updatedProduct.getProduct_name());
		existingProduct.setProduct_price(updatedProduct.getProduct_price());
		existingProduct.setProduct_imageName(updatedProduct.getProduct_imageName());
		existingProduct.setProduct_quantity(updatedProduct.getProduct_quantity());
		existingProduct.setStock(updatedProduct.isStock());
		existingProduct.setLive(updatedProduct.isLive());
		existingProduct.setProduct_description(updatedProduct.getProduct_description());

		Product save = productRepo.save(existingProduct);

		ProductDTO dto = toDTO(save);
		return dto;

	}

	// productdto to product
	public Product toEntity(ProductDTO pDTO) {
		Product p = new Product();
		// Exclude product_id because it's typically generated by the database
		p.setProduct_name(pDTO.getProduct_name());
		p.setProduct_price(pDTO.getProduct_price());
		p.setProduct_imageName(pDTO.getProduct_imageName());
		p.setProduct_quantity(pDTO.getProduct_quantity());
		p.setStock(pDTO.isStock());
		p.setLive(pDTO.isLive());
		p.setProduct_description(pDTO.getProduct_description());

		return p;
	}

	// product to productdto
	public ProductDTO toDTO(Product product) {
		ProductDTO pDTO = new ProductDTO();
		pDTO.setProduct_id(product.getProduct_id());
		pDTO.setProduct_name(product.getProduct_name());
		pDTO.setProduct_price(product.getProduct_price());
		pDTO.setProduct_imageName(product.getProduct_imageName());
		pDTO.setProduct_quantity(product.getProduct_quantity());
		pDTO.setStock(product.isStock());
		pDTO.setLive(product.isLive());
		pDTO.setProduct_description(product.getProduct_description());

		return pDTO;
	}

}
