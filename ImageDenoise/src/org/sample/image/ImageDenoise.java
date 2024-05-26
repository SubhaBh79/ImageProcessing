package org.sample.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.sample.image.process.ImageProcessor;
import org.sample.image.service.ImageConverter;
import org.sample.image.service.ImageReaderWriter;

public class ImageDenoise {

	public static void main(String[] args) {
		ImageReaderWriter imgReadWrite = new ImageReaderWriter();
		ImageConverter imgCon = new ImageConverter();
		ImageProcessor processor = new ImageProcessor();
		try {
			BufferedImage srcImg = imgReadWrite.readRGBImage(args[0]);
			List<Map<String, Integer>> rgbArray= imgCon.imageToRGBArray(srcImg);
			imgReadWrite.writeRGBImage(args[1], imgCon.rgbArrayToImage(processor.changeImagePixel(rgbArray,10000)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
