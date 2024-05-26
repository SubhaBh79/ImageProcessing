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
}
