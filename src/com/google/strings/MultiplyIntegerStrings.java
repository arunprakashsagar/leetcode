package com.google.strings;

public class MultiplyIntegerStrings {

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));

	}

	public static String multiply(String num1, String num2) {

		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int n1 = num1.length();
		int n2 = num2.length();
		int r = n1 + n2;
		int[] ans = new int[r];

		for (int i = n1 - 1; i >= 0; i--) {
			int k = --r;
			int carry = 0;
			int a = num1.charAt(i)-'0';
			for (int j = n2 - 1; j >= 0; j--) {
				int b = num2.charAt(i)-'0';
				int mul = a*b + carry + ans[k];
				carry = mul/10;
				ans[k--] += mul%10;
			}
			if(carry > 0)
				ans[k] += carry;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		int i = 0;
		while(ans[i+1] == 0)i++;
		while(++i < ans.length) {			
			sb.append(ans[i]);
		}
		return sb.toString();
	}

}
