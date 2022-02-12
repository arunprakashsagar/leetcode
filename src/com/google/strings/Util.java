package com.google.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	private static Random rand = new Random();
	
	public Util() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printList(List<Integer> list) {
		for (int num : list)
			System.out.print(num + " ");
		System.out.println();
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
	
	public static ArrayList<Integer> getArrayList(int size){
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i=1; i<=size;i++)
			A.add(i);
		return A;
	}
	
	public static ArrayList<Integer> getRandomArrayList(int size){
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		for(int i=1; i<=size;i++)
			A.add(rand.nextInt(size));
		return A;
	}
}
