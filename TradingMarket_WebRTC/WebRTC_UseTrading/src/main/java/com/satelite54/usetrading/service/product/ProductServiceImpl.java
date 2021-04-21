package com.satelite54.usetrading.service.product;

import java.sql.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.satelite54.usetrading.model.product.dao.ProductDAOImpl;
import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.product.dto.ProductHeartDTO;
import com.satelite54.usetrading.model.user.dao.UserDAOImpl;
import com.satelite54.usetrading.util.FileUploadService;

@Service
public class ProductServiceImpl implements IProductService{

	private ProductDAOImpl productDAO;
	private UserDAOImpl userDAO;
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
		if(photos.get(0).isEmpty()) {
			productDTO.setPPhotoPath("noimg.gif");
		} else {
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
		}
		return productDAO.setItem(productDTO);
	}
	
	@Override
	public List<ProductDTO> getsearchproducts(String search) {
		return productDAO.getsearchproducts(search);
	}
	
	@Override
	public int updateView(String pNum) {
		return productDAO.updateView(pNum);
	}
	
	@Override
	public boolean productheartInsertOrUpdate(String pNum, String uNum, String nbool) {
		boolean result = false;
		if(productDAO.getproductheart(pNum, uNum, nbool) == null) {
			nbool = "1";
			productDAO.setproductheart(pNum, uNum, nbool);
			result = true;
		} else {
			int nboolInt = Integer.parseInt(nbool);
			if(nboolInt == 1) {
				productDAO.updateproductheart(pNum, uNum, nbool);
			} else {
				nboolInt = 0;
				productDAO.updateproductheart(pNum, uNum, String.valueOf(nboolInt));
			}
			result = true;
		}
		return result;
	}
	
	@Override
	public int updateproductheart(String pNum, String uNum, String nbool) {
		return productDAO.updateproductheart(pNum, uNum, nbool);
	}
	
	@Override
	public int setproductheart(String pNum, String uNum, String nbool) {
		// TODO Auto-generated method stub
		return productDAO.setproductheart(pNum, uNum, nbool);
	}
	
@Override
	public int getproductheartcount(String pNum, String nbool) {
		return productDAO.getproductheartcount(pNum, nbool);
	}
	
	@Override
	public String[] splitPath (String paths) {
		StringTokenizer sk = new StringTokenizer(paths, " ");
		String[] splitpath = new String[sk.countTokens()];
		
		int i = 0;
		while(sk.hasMoreElements()) {
			splitpath[i] = sk.nextToken();
			i++;
		}
		return splitpath;
	}
}
