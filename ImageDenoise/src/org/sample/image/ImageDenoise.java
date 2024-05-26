package org.sample.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.sample.image.service.ImageConverter;
import org.sample.image.service.ImageReaderWriter;

public class ImageDenoise {

	public static void main(String[] args) {
		ImageReaderWriter imgReadWrite = new ImageReaderWriter();
		ImageConverter imgCon = new ImageConverter();
		try {
			BufferedImage srcImg = imgReadWrite.readRGBImage(args[0]);
			imgReadWrite.writeRGBImage(args[1], imgCon.rgbArrayToImage(imgCon.imageToRGBArray(srcImg)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
