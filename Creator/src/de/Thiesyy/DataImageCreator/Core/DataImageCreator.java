package de.Thiesyy.DataImageCreator.Core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;
import java.util.Random;

import javax.imageio.ImageIO;

public class DataImageCreator {
public static void main(String[] args) {
CreateImage("Test.png", "Cyka Blyat".getBytes());
}
public static void CreateImage(String file, byte[] bs) {
File f = new File(file);
BufferedImage img = new BufferedImage(bs.length*8, 1, BufferedImage.TYPE_INT_ARGB);
Graphics2D g = img.createGraphics();

int x = 0;
for(byte byt : bs) {
	
	String s1 = String.format("%8s", Integer.toBinaryString(byt & 0xFF)).replace(' ', '0');


	for (int i = 0; i < s1.length(); i++){
	    char c = s1.charAt(i);        
	  if(c == '1') {
		  g.setColor(Color.BLACK);
		  g.fillRect(x, 0, 1, 1);
	  }else {
		  g.setColor(Color.WHITE);
		  g.fillRect(x, 0, 1, 1);
	  }
	  System.out.print(c);
	  x++;  
	}
	
	
			
		
	
}

try {
	ImageIO.write(img, "png", f);
} catch (IOException e) {
}

}

}
