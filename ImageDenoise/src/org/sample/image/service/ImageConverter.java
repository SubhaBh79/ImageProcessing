package org.sample.image.service;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sample.image.constant.Constant;

public class ImageConverter {

	private int imageHeight = 0;
	private int imageWidth = 0;
	
	public List<Map<String, Integer>> imageToRGBArray(BufferedImage img) {
		List<Map<String, Integer>> rgbArray = new ArrayList<Map<String, Integer>>();
		this.imageHeight = img.getHeight();
		this.imageWidth = img.getWidth();
		int[] pixels = img.getRGB(0, 0, this.imageWidth, this.imageHeight, null, 0, this.imageWidth);
		for (int pixel : pixels) {
			Map<String, Integer> rgbEntry = new HashMap<String, Integer>();
			rgbEntry.put(Constant.ALPHA, (pixel >> 24) & 0xff);
			rgbEntry.put(Constant.RED, (pixel >> 16) & 0xff);
			rgbEntry.put(Constant.GREEN, (pixel >> 8) & 0xff);
			rgbEntry.put(Constant.BLUE, pixel & 0xff);

			rgbArray.add(rgbEntry);
		}
		return rgbArray;
	}

	public BufferedImage rgbArrayToImage(List<Map<String, Integer>> rgbArray) {
		List<Integer> pixels = new ArrayList<Integer>();
		for (Map<String, Integer> rgbEntry : rgbArray) {
			int pixel = (rgbEntry.get(Constant.ALPHA) << 24) | (rgbEntry.get(Constant.RED) << 16)
					| (rgbEntry.get(Constant.GREEN) << 8) | rgbEntry.get(Constant.BLUE);
			pixels.add(pixel);
		}
		BufferedImage img = new BufferedImage(this.imageWidth, this.imageHeight, Constant.RGB_IMAGE_TYPE);
		int[] imgPixels = pixels.stream().mapToInt(i->i).toArray();
		img.setRGB(0, 0, this.imageWidth, this.imageHeight, imgPixels, 0, this.imageWidth);
		return img;
	}
}
