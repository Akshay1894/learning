package site.akshay.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Count {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk","","",""); 
		long count = strList.stream() .filter(x -> x.isEmpty()) .count();
		System.out.println("Empty string Count is "+count);
		
		long num = strList.stream().filter(x -> x.length()> 3).count();
		System.out.println("Count More than 3 is " + num);
		
		long astart = strList.stream().filter(x -> x.startsWith("a")).count();
		System.out.println("Starts with a is " + astart);
		
		List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
		String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", "));
		System.out.println(G7Countries);
		
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4); 
		List<Integer> distinct = numbers.stream() .map( i -> i*i) .distinct() .collect(Collectors.toList());
		System.out.println(distinct);
		
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); 
		IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();
		System.out.println(stats);
		System.out.println("Max value is "+stats.getMax());
	}

}
