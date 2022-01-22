package com.google.strings;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printArr(int[] arr) {
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}

	public static void printArr(int[][] arr) {
		for (int[] num : arr)
			printArr(num);
		System.out.println();
	}
}
