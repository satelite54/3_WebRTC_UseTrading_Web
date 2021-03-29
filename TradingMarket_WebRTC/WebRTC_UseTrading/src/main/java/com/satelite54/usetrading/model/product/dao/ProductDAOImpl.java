package com.satelite54.usetrading.model.product.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satelite54.usetrading.model.product.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements IProductDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private ProductDTO productDTO;
	private static final String NAMESPACE = "com.satelite54.usetrading.model.board";
	
	@Autowired
	public ProductDAOImpl(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	
	@Override
	public ProductDTO getItem(int pNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", pNum);
		productDTO = sqlSession.selectOne("getItem", paramMap);
		return productDTO;
	}
	@Override
	public List<ProductDTO> getPopularityItems(Date searchDate) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pUpLoadTime", searchDate);
		List<ProductDTO> productlist = sqlSession.selectList("getPopularityItems", paramMap);
		
		
		return productlist;
	}
	@Override
	public List<ProductDTO> getTogetherViewItems(int pNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", pNum);
		List<ProductDTO> productlist = sqlSession.selectList("getTogetherViewItems", paramMap);
		return productlist;
	}
}
