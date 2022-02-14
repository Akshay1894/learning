package site.akshay.java8;

import java.util.Arrays;

public class OddEven {
	public static void main(String[] args) {
        int[] numbers = {2, 5, 7, 8, 99, 1, 22, 4, 3, 77, 66};
        
        System.out.println("Odd Numbers");
        Arrays.stream(numbers).filter(o -> o % 2 == 0).forEach(System.out::println);
        
        System.out.println("Even Numbers");
        Arrays.stream(numbers).filter(o -> o % 2 != 0).forEach(System.out::println);
    }
}
