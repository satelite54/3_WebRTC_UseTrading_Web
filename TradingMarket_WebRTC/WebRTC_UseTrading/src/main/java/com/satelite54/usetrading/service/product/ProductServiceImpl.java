package com.satelite54.usetrading.service.product;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.satelite54.usetrading.model.product.dao.ProductDAOImpl;
import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.util.FileUploadService;

@Service
public class ProductServiceImpl implements IProductService{

	private ProductDAOImpl productDAO;
	private FileUploadService fileUploadService;
	
	@Autowired
	public ProductServiceImpl(ProductDAOImpl productDAO, FileUploadService fileUploadService) {
		this.productDAO = productDAO;
		this.fileUploadService = fileUploadService;
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

	@Override
	public int setItem(ProductDTO productDTO, List<MultipartFile> photos) {
		if(photos != null) {
			StringBuilder saveurlsb = new StringBuilder();
			for(MultipartFile photo : photos) {
				if(photos.indexOf(photo) != photos.size() - 1) {
					saveurlsb.append(fileUploadService.restore(photo));
					saveurlsb.append(' ');
				} else if (photos.indexOf(photo) == photos.size() - 1){
					saveurlsb.append(fileUploadService.restore(photo));
				} 
			}
			productDTO.setPPhotoPath(saveurlsb.toString());
		} else {
			productDTO.setPPhotoPath("");
		}
		return productDAO.setItem(productDTO);
	}
	
	@Override
	public List<ProductDTO> getsearchproducts(String search) {
		return productDAO.getsearchproducts(search);
	}
}
