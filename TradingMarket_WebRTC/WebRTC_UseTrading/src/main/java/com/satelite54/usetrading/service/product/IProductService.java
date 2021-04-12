package com.satelite54.usetrading.service.product;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.product.dto.ProductDTO;

public interface IProductService {
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
}
