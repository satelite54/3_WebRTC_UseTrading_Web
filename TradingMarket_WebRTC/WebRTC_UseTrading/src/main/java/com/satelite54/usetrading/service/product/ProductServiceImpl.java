package com.satelite54.usetrading.service.product;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.product.dao.ProductDAOImpl;
import com.satelite54.usetrading.model.product.dto.ProductDTO;

@Service
public class ProductServiceImpl implements IProductService{
	
	private ProductDAOImpl productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAOImpl productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public ProductDTO getItem(int pNum) {
		return productDAO.getItem(pNum);
	}
	@Override
	public List<ProductDTO> getPopularityItems(Date searchDate) {
		return productDAO.getPopularityItems(searchDate);
	}
	@Override
	public List<ProductDTO> getTogetherViewItems(int pNum) {
		return productDAO.getTogetherViewItems(pNum);
	}
}
