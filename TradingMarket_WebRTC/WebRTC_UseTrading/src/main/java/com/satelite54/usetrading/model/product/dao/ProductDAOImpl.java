package com.satelite54.usetrading.model.product.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satelite54.usetrading.model.product.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements IProductDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;

	private ProductDTO productDTO;

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

	@Override
	public int setItem(ProductDTO productDTO) {
		return sqlSession.insert("setItem", productDTO);
	}

	@Override
	public List<ProductDTO> getsearchproducts(String search) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(CheckNumber(search)) {
			paramMap.put("pNum", search);
		} else {
			paramMap.put("search", search);			
		}
		return sqlSession.selectList("getsearchproducts", paramMap);
	}

	@Override
	public int updateView(String pNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", Integer.parseInt(pNum));
		return sqlSession.update("updateView", paramMap);
	}
	
	public boolean CheckNumber(String str){
		char check;
		if(str.equals("")) {
			//문자열이 공백인지 확인
			return false;
		}

		for(int i = 0; i<str.length(); i++){
			check = str.charAt(i);
			if( check < 48 || check > 58) {
				//해당 char값이 숫자가 아닐 경우
				return false;
			}
		}		
		return true;
	}
}
