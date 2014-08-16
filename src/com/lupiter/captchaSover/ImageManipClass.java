package com.lupiter.captchaSover;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManipClass{
	
	BufferedImage bImage = null;
	BufferedImage newImage = null;
	int imageWidth;
	int imageHeight;
	
	//this will be called with the file name+extension passed into the method
	ImageManipClass(String image){
		BufferedImage rImage = null;
		try {
			rImage = ImageIO.read(new File(image));
			this.bImage = rImage;
			imageWidth = this.bImage.getWidth();
			imageHeight = this.bImage.getHeight();
			
		}catch(Exception e) { 
			e.printStackTrace();
		}
	}
	void scrubHorizontal(){
		//Do it later
		if(newImage == null){
			newImage = bImage;
		}
		for(int pixelY = 0; pixelY < imageHeight - 1; pixelY++){
			for(int pixelX = 0; pixelX < imageWidth - 1; pixelX++){
				if(newImage.getRGB(pixelX, pixelY) == Color.black.getRGB() && newImage.getRGB(pixelX + 1, pixelY) == Color.white.getRGB()){
					newImage.setRGB(pixelX, pixelY, Color.WHITE.getRGB());
				}
			}
		}
	}
	
	void scrubDown(){
		if(newImage == null){
			newImage = bImage;
		}
		for(int pixelY = 0; pixelY < imageHeight - 1; pixelY++){
			for(int pixelX = 0; pixelX < imageWidth - 1; pixelX++){
				if(newImage.getRGB(pixelX, pixelY) == Color.black.getRGB() && newImage.getRGB(pixelX , pixelY + 1) == Color.white.getRGB()){
					newImage.setRGB(pixelX, pixelY, Color.WHITE.getRGB());
				}
			}
		}
	}
	
	void scrubDiagonalLtoR(){
		if(newImage == null){
			newImage = bImage;
		}
		for(int pixelY = 0; pixelY < imageHeight - 1; pixelY++){
			for(int pixelX = 0; pixelX < imageWidth - 1; pixelX++){
				if(newImage.getRGB(pixelX, pixelY) == Color.black.getRGB() && newImage.getRGB(pixelX + 1, pixelY + 1) == Color.white.getRGB()){
					newImage.setRGB(pixelX, pixelY, Color.WHITE.getRGB());
				}
			}
		}
	}
	
	void blackFilter(){
		if(newImage == null){
			newImage = bImage;
		}
		for(int pixelY = 0; pixelY < imageHeight; pixelY++){
			for(int pixelX = 0; pixelX < imageWidth; pixelX++){
				if(newImage.getRGB(pixelX,pixelY) < -9000000){
					newImage.setRGB(pixelX, pixelY, Color.black.getRGB());
				}else if (newImage.getRGB(pixelX,pixelY) >= -9000000){
					newImage.setRGB(pixelX, pixelY, Color.white.getRGB());
				}
			}
		}
	}

	void saveNew(String name){
		//Do it later
		if(newImage == null){
			newImage = bImage;
		}
		try {  
			File outputFile = new File(name);
	        ImageIO.write(newImage, "png", outputFile);
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
	int getWidth(){
		return imageWidth;
	}
	int getHeight(){
		return imageHeight;
	}
}


