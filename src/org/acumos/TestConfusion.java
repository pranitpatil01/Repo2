package org.acumos;

import java.util.ArrayList;
import java.util.List;

public class TestConfusion {

	public static void main(String[] args) {
		List<String> truthvalue= new ArrayList();
		truthvalue.add("1");
		truthvalue.add("0");
		truthvalue.add("4");
		truthvalue.add("2");
		
		List<String> predictionvalue= new ArrayList<String>();
		predictionvalue.add("1");
		predictionvalue.add("0");
		predictionvalue.add("1");
		predictionvalue.add("1");
		
		ConfusionMetrics2 confusion= new ConfusionMetrics2();
		confusion.getConfusionMatrix2(truthvalue, predictionvalue);
		System.err.println(confusion);

	}

}
