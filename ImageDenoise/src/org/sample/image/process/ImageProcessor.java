package org.sample.image.process;

import java.util.List;
import java.util.Map;

import org.sample.image.constant.Constant;

public class ImageProcessor {

	public List<Map<String, Integer>> changeImagePixel(List<Map<String, Integer>> rgbArray,int changeValue) {
		for (Map<String, Integer> rgbEntry : rgbArray) {
			rgbEntry.put(Constant.ALPHA, rgbEntry.get(Constant.ALPHA)+changeValue);
			rgbEntry.put(Constant.RED, rgbEntry.get(Constant.RED)+changeValue);
			rgbEntry.put(Constant.GREEN, rgbEntry.get(Constant.GREEN)+changeValue);
			rgbEntry.put(Constant.BLUE, rgbEntry.get(Constant.BLUE)+changeValue);
		}
		return rgbArray;
	}
	
	public List<Map<String, Integer>> setHue(List<Map<String, Integer>> rgbArray, String hueValue) {
		for (Map<String, Integer> rgbEntry : rgbArray) {
			for (Map.Entry<String, Integer> entry : rgbEntry.entrySet()) {
				if(entry.getKey() == Constant.ALPHA) {
					continue;
				}
				else if(entry.getKey() == hueValue) {
					continue;
				}
				else {
					rgbEntry.put(entry.getKey(), 0);
				}
			}
		}
		return rgbArray;
	}
	
	public List<Map<String, Integer>> createNegativeRGB(List<Map<String, Integer>> rgbArray) {
		for (Map<String, Integer> rgbEntry : rgbArray) {
			rgbEntry.put(Constant.RED, 255 - rgbEntry.get(Constant.RED));
			rgbEntry.put(Constant.GREEN, 255 - rgbEntry.get(Constant.GREEN));
			rgbEntry.put(Constant.BLUE, 255 - rgbEntry.get(Constant.BLUE));
		}
		return rgbArray;
	}
	
	public List<Map<String, Integer>> createGrayscaleValue(List<Map<String, Integer>> rgbArray) {
		for (Map<String, Integer> rgbEntry : rgbArray) {
			int avg = (rgbEntry.get(Constant.RED) + rgbEntry.get(Constant.GREEN) + rgbEntry.get(Constant.BLUE)) /3;
			rgbEntry.put(Constant.RED, avg);
			rgbEntry.put(Constant.GREEN, avg);
			rgbEntry.put(Constant.BLUE, avg);
		}
		return rgbArray;
	}
}
