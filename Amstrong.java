package com.akshay.learning;

import java.util.Scanner;

public class Amstrong {

	public static void main(String[] args) {
		long a, temp;
		long baseNumber = 0;
		long sum = 0;
		long digits = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the number : ");
		a = sc.nextLong();//153
		temp = a;
		while (temp > 0) {
			temp = temp / 10;//15//1/0
			digits++;//1//2//3
		}
		temp = a;//153
		while (temp > 0) {
			baseNumber = temp % 10;//3//5//1
			temp = temp / 10;//15//1//0
			sum = sum + (long) +(Math.pow(baseNumber, digits));//27//27+125=152//27+125+1=153
		}
		if (a == sum) {
			System.out.println("Amstrong Number : " + sum);
		} else {
			System.out.println("Not an Amstrong Number : " + a);
		}

	}

}
