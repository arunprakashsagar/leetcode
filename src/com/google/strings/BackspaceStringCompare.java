package com.google.strings;

public class BackspaceStringCompare {

	public BackspaceStringCompare() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String s = "nzp#o#g";
		String t = "b#nzp#o#g";
		System.out.println(backspaceCompare(s, t));

	}

	private static boolean backspaceCompare(String s, String t) {
		// TODO Auto-generated method stub
		if (s == null || t == null)
			return false;
		int i = s.length() - 1, j = t.length() - 1;

		while (i >= 0 || j >= 0) {
			i = getValidCharIndx(s, i);
			j = getValidCharIndx(t, j);

			if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
				return false;
			if ((i >= 0) != (j >= 0))
				return false;
			i--;
			j--;
		}
		return (i < 0 && j < 0);
	}

	private static int getValidCharIndx(String s, int i) {
		int count = 0;
		while (i >= 0) {
			if (s.charAt(i) == '#') {
				count++;
				i--;
			} else if (count > 0) {
				count--;
				i--;
			} else
				return i;
		}
		return i;
	}

}
