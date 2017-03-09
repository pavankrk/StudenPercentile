package com.calculatepercentile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
 * 
 * author: Pavan
 */

public class StudentPercentile {

		public static void main(String[] args) throws IOException {

		Map<String, StudentDetails> studentdata = new LinkedHashMap<>();

		Stream<String> lines = 
				Files.lines(
						Paths.get("files", "testcase.txt"),
						Charset.forName("windows-1252")
						);
		
		ArrayList<Double> doubleArray = new ArrayList<Double>();
		
		lines.forEach(
				(String line) ->{
					    String[] elements = line.split(",");
					
					    StudentDetails sd = new StudentDetails();
					    sd.setId(elements[0]);
				     	sd.setName(elements[1].replace("\"", ""));
				    	sd.setGpa(Double.parseDouble(elements[2]));
					
				    	doubleArray.add(sd.getGpa());
					    studentdata.put(sd.getName(), sd);				
				        }
				      );
		
		calculatePR(studentdata,doubleArray);
        
		lines.close();
        studentdata.clear();
		}

	private static void calculatePR(Map<String, StudentDetails> studentDetails, ArrayList<Double> doubleArray) {
		calculatePaercentileRank pr = new calculatePaercentileRank();
		pr.setData(doubleArray);
		
		studentDetails
        .entrySet()
        .stream()
        .sorted(Map.Entry.<String, StudentDetails>comparingByKey())
        .forEach(x -> System.out.println("Name\t   : "+ x.getValue().getName()
		                                          + "\nGPA\t   : "+ x.getValue().getGpa()
		                                          +"\n"+ pr.percentile_Rank(x.getValue().getGpa())
		                                          +"\n____________________________________"));

		
		
	}

}
