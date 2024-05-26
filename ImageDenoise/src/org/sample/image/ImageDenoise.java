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
			BufferedImage desImage = null;
			switch (args[2]) {
			case "CHANGE_PIXEL":
				int pixelValue = Integer.valueOf(args[3]);
				desImage = imgCon.rgbArrayToImage(processor.changeImagePixel(rgbArray,pixelValue));
				break;
			case "CHANGE_HUE":
				desImage = imgCon.rgbArrayToImage(processor.setHue(rgbArray,args[3]));
				break;
			case "NEGATIVE":
				desImage = imgCon.rgbArrayToImage(processor.createNegativeRGB(rgbArray));
				break;
			case "GRAYSCALE":
				desImage = imgCon.rgbArrayToImage(processor.createGrayscaleValue(rgbArray));
				break;
			default:
				break;
			}
			imgReadWrite.writeRGBImage(args[1],desImage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
