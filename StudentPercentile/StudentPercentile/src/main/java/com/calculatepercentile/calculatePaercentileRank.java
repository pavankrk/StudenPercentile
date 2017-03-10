package com.calculatepercentile;

import java.util.ArrayList;
import java.util.Collections;

public class calculatePaercentileRank {
	protected ArrayList<Double> data;

	public void setData(final ArrayList<Double> data) {
		Collections.sort(data);
		this.data = data;
	}

	public String percentile_Rank(final double value) {
		String result = null;
		if (data.isEmpty()) {
			throw new IllegalArgumentException("Student Data  array is empty");
		}

		int lowerCount = 0;
		int sameCount = 0;
		int n = data.size();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) < value) {
				lowerCount++;
			} else if (data.get(i) == value) {
				sameCount++;
			} else {
				break;
			}
		}
		double p = (lowerCount + 0.5 * sameCount) / n * 100;
		double r = ((100 - p) * data.size() )/ 100;
		result = "Percentile : " + p + " \nRank\t   : " + Integer.valueOf((int) Math.ceil(r));
		return result;
	}

	}
