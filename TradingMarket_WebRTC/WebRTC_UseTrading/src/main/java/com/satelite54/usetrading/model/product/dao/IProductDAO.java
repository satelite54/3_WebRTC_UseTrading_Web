package com.satelite54.usetrading.model.product.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.product.dto.ProductHeartDTO;

public interface IProductDAO {
	//�� ��ǰ �ڼ��� ����
	//pNum �ϳ� �޾Ƽ� DTO ���� �ִ� �޼ҵ�
	ProductDTO getItem(int pNum);
	
	//�� ��ǰ�� �Բ� �þ��
	//���� ���͸� ����
	List<ProductDTO> getTogetherViewItems(int pNum);
	
	//�߰�ŷ� �α�Ź�(����ȭ��)
	//����, ä�ð���, ������ �Ⱓ ���� ������ �����ؼ� 8�� DTO �����ִ� �޼ҵ�
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
