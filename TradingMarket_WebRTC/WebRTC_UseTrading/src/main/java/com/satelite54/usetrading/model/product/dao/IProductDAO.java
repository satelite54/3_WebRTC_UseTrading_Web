package com.satelite54.usetrading.model.product.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.product.dto.ProductHeartDTO;

public interface IProductDAO {
	//한 상품 자세히 보기
	//pNum 하나 받아서 DTO 던져 주는 메소드
	ProductDTO getItem(int pNum);
	
	//이 상품과 함께 봤어요
	//협업 필터링 적용
	List<ProductDTO> getTogetherViewItems(int pNum);
	
	//중고거래 인기매물(매인화면)
	//관심, 채팅개수, 설정한 기간 따라 아이템 정렬해서 8개 DTO 던져주는 메소드
	List<ProductDTO> getPopularityItems(Date searchDate);
	
	int setItem(ProductDTO productDTO);
	List<ProductDTO> getsearchproducts(String search);
	
	int updateView(String pNum);
	ProductHeartDTO getproductheart(String pNum, String uNum, String nbool);
	int setproductheart(String pNum, String uNum, String nbool);
	int updateproductheart(String pNum, String nNum, String nbool);
	int getproductheartcount(String pNum, String nbool);
	String getboolheart(String pNum);
}
