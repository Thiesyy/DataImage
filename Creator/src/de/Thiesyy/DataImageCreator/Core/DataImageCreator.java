package de.Thiesyy.DataImageCreator.Core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class DataImageCreator {
public static void main(String[] args) throws IOException {
CreateImage("Test.png", "Blyatttaa".getBytes());
}
public static void CreateImage(String file, byte[] bs) {
File f = new File(file);

//System.out.println(bs.length);
BufferedImage img = new BufferedImage(8, bs.length, BufferedImage.TYPE_INT_ARGB);
Graphics2D g = img.createGraphics();
int y = 0;
int x = 0;
for(byte byt : bs) {
	
	String s1 = String.format("%8s", Integer.toBinaryString(byt & 0xFF)).replace(' ', '0');


	for (int i = 0; i < s1.length(); i++){
	    char c = s1.charAt(i);        
	  if(c == '1') {
		  g.setColor(Color.BLACK);
		  g.fillRect(x, y, 1, 1);
	  }else {
		  g.setColor(Color.WHITE);
		  g.fillRect(x, y, 1, 1);
	  }
	//  System.out.print(c);
	  x++;
	  if(x == 8) {
		  x = 0;
		  y++;
	  }
	//  if(y > bs.length*8)
	//	  throw new StackOverflowError();
	}
	
	
			
		
	
}

try {
	ImageIO.write(img, "png", f);
} catch (IOException e) {
}

}

}
