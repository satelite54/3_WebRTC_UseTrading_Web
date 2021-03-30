package com.satelite54.usetrading.model.product.dto;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Repository
public class ProductDTO {
	
	private int pNum;
	private String pName;
	private int pDivide;
	private Date pUpLoadTime;
	private int pPrice;
	private int pChatNum;
	private int pHeart;
	private int pView;
	private String pTitle;
	private String pContent;
	private String pPhotoPath;
}
