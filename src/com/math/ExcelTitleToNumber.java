package com.math;

public class ExcelTitleToNumber {

	public ExcelTitleToNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(convertExcelTitleToNumber("AABQT")); // 476366
	}
	
	public static int convertExcelTitleToNumber(String A) {
		if(A == null || A.trim().length() == 0)
			return 0;
		int ans = 0;
		for(char c : A.toCharArray()) {
			int num = (int)(c - 'A' + 1);
			ans = ans*26 + num;
		}
		return ans;	
	}

}
