package com.math;

public class ExcelColumnNameFromNumber {

	public ExcelColumnNameFromNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(convertNumberToExcelColumn(476366)); //"AABQT"
	}

	public static String convertNumberToExcelColumn(int num) {

		String ans = "";
		while (num > 0) {
			num = num - 1;
			int x = num % 26;
			ans = (char) ('A' + x) + ans;
			num = num / 26;
		}
		return ans;
	}

}
