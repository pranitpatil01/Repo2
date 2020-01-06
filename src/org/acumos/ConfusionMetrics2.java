package org.acumos;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfusionMetrics2 {

	private int[][] matrix;
	
	public int[][] getConfusionMatrix2(List<?> truthvalue, List<?> predictionvalue) {
		
		List<Object> t=(List<Object>) truthvalue;
		List<Object>p= (List<Object>) predictionvalue;
		List<String> truth = t.stream()
				   .map(object -> Objects.toString(object, null))
				   .collect(Collectors.toList());
		List<String> prediction = p.stream()
				   .map(object -> Objects.toString(object, null))
				   .collect(Collectors.toList());
		
		if(truth.size() != prediction.size()){
			 throw new IllegalArgumentException(String.format("The vector sizes don't match: %d != %d.", truth.size(), prediction.size()));
		}
		
		Set<Integer> ySet = new HashSet<>();
		
		for(int i = 0; i < truth.size(); i++){
			ySet.add(Integer.parseInt(truth.get(i)));
		}
		
		matrix = new int[ySet.size()][ySet.size()];
		
		for(int i = 0; i < truth.size(); i++){
			matrix[Integer.parseInt(truth.get(i))][Integer.parseInt(prediction.get(i))] += 1;
		}
		
		ySet.clear();
		
		return matrix;
	}
	
    public int[][] getMatrix() {
        return matrix;
    }
    
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ROW=truth and COL=predicted\n");
		
		for(int i = 0; i < matrix.length; i++){
			sb.append(String.format("class %2d |", i));
			for(int j = 0; j < matrix.length; j++){
				sb.append(String.format("%8d |", matrix[i][j]));
			}
			sb.append("\n");
 		}
		
		return sb.toString().trim();
	}

}
