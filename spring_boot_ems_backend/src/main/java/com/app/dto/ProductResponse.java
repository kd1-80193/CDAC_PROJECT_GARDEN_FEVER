package com.app.dto;

import java.util.List;

import com.app.entities.Product;
public class ProductResponse {

    private List<ProductDTO> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private boolean lastPage;
    

    public ProductResponse(List<ProductDTO> content, int pageNumber, int pageSize, int totalPages, boolean lastPage) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.lastPage = lastPage;
    }
    


	public ProductResponse() {
		super();
	}



	public List<ProductDTO> getContent() {
		return content;
	}


	public void setContent(List<ProductDTO> content) {
		this.content = content;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	public boolean isLastPage() {
		return lastPage;
	}


	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

    
}
