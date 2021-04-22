package com.satelite54.usetrading.model.product.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.product.dto.ProductHeartDTO;

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
			//���ڿ��� �������� Ȯ��
			return false;
		}

		for(int i = 0; i<str.length(); i++){
			check = str.charAt(i);
			if( check < 48 || check > 58) {
				//�ش� char���� ���ڰ� �ƴ� ���
				return false;
			}
		}		
		return true;
	}

	@Override
	public ProductHeartDTO getproductheart(String pNum, String uNum, String nbool) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", Integer.parseInt(pNum));
		return sqlSession.selectOne("getproductheart", paramMap);
	}
	@Override
	public int setproductheart(String pNum, String uNum, String nbool) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", Integer.parseInt(pNum));
		paramMap.put("uNum", Integer.parseInt(uNum));
		paramMap.put("nbool", Integer.parseInt(nbool));
		return sqlSession.insert("setproductheart", paramMap);
	}
	@Override
	public int updateproductheart(String pNum, String uNum, String nbool) {
		if(nbool == "") {
			nbool = "0";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", Integer.parseInt(pNum));
		paramMap.put("uNum", Integer.parseInt(uNum));
		paramMap.put("nbool", Integer.parseInt(nbool));
		return sqlSession.update("updateproductheart", paramMap);
	}
	@Override
	public int getproductheartcount(String pNum, String nbool) {
		if(nbool == "") {
			nbool = "0";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", Integer.parseInt(pNum));
		paramMap.put("nbool", Integer.parseInt(nbool));
		return sqlSession.selectOne("getproductheartcount", paramMap);
	}
	
	@Override
	public String getboolheart(String pNum) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pNum", Integer.parseInt(pNum));
		return sqlSession.selectOne("getboolheart", paramMap);
	}
}
