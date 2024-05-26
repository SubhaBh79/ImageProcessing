package org.sample.image.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ImageReaderWriter {
	public BufferedImage readRGBImage(String filePath) throws IOException {
		BufferedImage img = ImageIO.read(
				new File(filePath)
				);
		return img;
	}
	
	public void writeRGBImage(String filePath,BufferedImage img) throws IOException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(filePath);
		buffer.append("/");
		buffer.append("RGB-Converted-");
		buffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		buffer.append(".jpg");
		File outputFile = new File(buffer.toString());
		ImageIO.write(img, "jpg", outputFile);
		System.out.println("RGB Image created at "+outputFile.getAbsolutePath());
	}
}
