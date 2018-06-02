package de.Thiesyy.DataImageLoader.Loader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

public class DataImageLoader {
public static void main(String[] args) throws IOException {
	byte[] returned = getBytesFromPicture("Test.png");
	String str = new String(returned, StandardCharsets.UTF_8);
	System.out.println(str);
}
public static byte[] getBytesFromPicture(String file) throws IOException {
	File f = new File(file);
	BufferedImage img = ImageIO.read(f);
	String a = "";
	for(int x = 0; x != img.getWidth(); x++) {
		 int clr=  img.getRGB(x,0); 
		  int  red   = (clr & 0x00ff0000) >> 16;
		  int  green = (clr & 0x0000ff00) >> 8;
		  int  blue  =  clr & 0x000000ff;
		Color c = Color.black;
		Color c2 = new Color(red,green,blue);
	//	if(c.getRed() == red && c.getBlue() == blue && c.getGreen() == green) {
		if(c.equals(c2)) {
		a +="1";
		}
		else {
			a +="0";
		}
		
	}
	byte[] toRet = new byte[a.length()/8];
	for(int y = 0; y != a.length()/8; y++) 
		toRet[y] = (byte) Integer.parseInt(a.substring(y*8, y*8+8), 2);
	
	return toRet;
}

}
