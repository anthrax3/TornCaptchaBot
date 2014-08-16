package com.lupiter.captchaSover;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CaptchaScrubber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fName = "4.png";
		ImageManipClass captcha = new ImageManipClass(fName);
		captcha.blackFilter();
		captcha.scrubDown();
		captcha.scrubHorizontal();
		captcha.scrubDiagonalLtoR();
		captcha.saveNew("new" + fName);
		

		
	}

}
