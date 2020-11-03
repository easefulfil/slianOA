package com.slianOAsys.service.utils;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class Encode {
	// 图片宽度的一�?
		private static final int IMAGE_WIDTH = 300;
		private static final int IMAGE_HEIGHT = 300;
		private static final int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;
		private static final int FRAME_WIDTH = 2;

		// 二维码写码器
		private static MultiFormatWriter mutiWriter = new MultiFormatWriter();
		
	    /**
	     * 二维码编�?
	     * @param contents
	     * @param width
	     * @param height
	     * @param imgPath
	     */
	    public static void encode(String contents, int width, int height, String imgPath) {
	    	
	    	Hashtable hints= new Hashtable();  
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
	        try {
	            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,BarcodeFormat.QR_CODE, width, height);

	            MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(imgPath));

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 二维码编�?
	     * @param contents
	     * @param width
	     * @param height
	     * @param imgPath
	     */
	    public static void createQRCode(String contents,String savePath,String fileName,int width, int height) {
	    	
	    	Hashtable hints= new Hashtable();  
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
	        
	        try {
	        	
	        	File filePath = new File(savePath);
	    		
	    		if(!filePath.exists()){
	    			filePath.mkdirs();
	    		}
	        	
	            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,BarcodeFormat.QR_CODE, IMAGE_WIDTH, IMAGE_HEIGHT);

	            MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(savePath +fileName));

	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	    }
}
