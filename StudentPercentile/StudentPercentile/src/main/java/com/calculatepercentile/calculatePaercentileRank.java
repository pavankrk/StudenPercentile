package com.calculatepercentile;

import java.util.ArrayList;

public class calculatePaercentileRank {
	protected ArrayList<Double> data;

	public void setData(final ArrayList<Double> data) {
		this.data = data;
	}

	public String percentile_Rank(final double value) {
		String result = null;
		if (data.isEmpty()) {
			throw new IllegalArgumentException("Student Data  array is empty");
		}

		int n = data.size();
		
		long lowerCount =  data.stream()
		                 .filter(s -> s < value)
		                 .count();
		
		long sameCount =   data.stream()
	                          .filter(s -> s == value)
	                          .count();
		
		double p = (lowerCount + 0.5 * sameCount) / n * 100;
		double r = ((100 - p) * n )/ 100;
		
		result = "Percentile : " + p + " \nRank\t   : " + Integer.valueOf((int) Math.ceil(r));
                return result;
	}

	}
