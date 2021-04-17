
package com.satelite54.usetrading.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	// ������ �������� ���� ��θ� �ۼ� ( ��Ʈ ����� /���� �����Ѵ�. )
	// �������� workspace�� ����̺긦 �ľ��Ͽ� JVM�� �˾Ƽ� ó�����ش�.
	// ���� workspace�� C����̺꿡 �ִٸ� C����̺꿡 upload ������ ������ ���ƾ� �Ѵ�.
	private static final String SAVE_PATH = "\\03_Git\\UseTrading_WebRTC\\TradingMarket_WebRTC\\WebRTC_UseTrading\\src\\main\\webapp\\resources\\img";
	private static final String PREFIX_URL = "\\03_Git\\UseTrading_WebRTC\\TradingMarket_WebRTC\\WebRTC_UseTrading\\src\\main\\webapp\\resources\\img\\";
	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
			// ���� ����
			String originFilename = multipartFile.getOriginalFilename();
			String extName
				= originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();
			
			// �������� ���� �� ���� �̸�
			String saveFileName = genSaveFileName(extName);
			
			System.out.println("originFilename : " + originFilename);
			System.out.println("extensionName : " + extName);
			System.out.println("size : " + size);
			System.out.println("saveFileName : " + saveFileName);
			
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
		}
		catch (IOException e) {
			// ������� RuntimeException �� ��ӹ��� ���ܰ� ó���Ǿ�� ������
			// ���ǻ� RuntimeException�� ������.
			// throw new FileUploadException();	
			throw new RuntimeException(e);
		}
		return url;
	}
	
	
	// ���� �ð��� �������� ���� �̸� ����
	private String genSaveFileName(String extName) {
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;
		
		return fileName;
	}
	
	
	// ������ ������ write �ϴ� �޼���
	private boolean writeFile(MultipartFile multipartFile, String saveFileName)
								throws IOException{
		boolean result = false;

		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(data);
		fos.close();
		
		return result;
	}
}
