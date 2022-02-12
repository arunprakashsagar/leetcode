package com.scaler.subarray;

import java.util.ArrayList;
import java.util.List;

import com.google.strings.Util;

public class SumOfAllSubArrayElementBitwiseOR {

	public SumOfAllSubArrayElementBitwiseOR() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List l = Util.getArrayList(5);
		Util.printList(l);
		//System.out.println(sumOfSubArrayBOR(l));
		System.out.println(sumOfSubArrayBORModified(l));
	}

	private static int sumOfSubArrayBORModified(List<Integer> list) {
		int sum = 0;
		int N = list.size();
		int[] bitArr = new int[32];

		for (int i = 1; i <= N; i++) {
			int num = list.get(i - 1);
			int pow = 1;
			for (int b = 0; b < 32; b++) {
				if ((num & pow) > 0) {
					sum += pow * i;
					bitArr[b] = i;
				} else if (bitArr[b] > 0) {
					sum += pow * bitArr[b];
				}
				pow = pow * 2;
			}
		}
		return sum;
	}

	private static int sumOfSubArrayBOR(List<Integer> list) {
		int sum = 0;
		int N = list.size();
		int totalSubArrays = N * (N + 1) / 2;

		int max = list.stream().max(Integer::compare).get();
		int maxBits = 0;
		while (max > 0) {
			maxBits++;
			max = max / 2;
		}
		int pow = 1;
		for (int b = 0; b <= maxBits; b++) {
			int numOfSubArrWithBitNotSet = 0;
			ArrayList<Integer> elementsWitBitNotSet = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				int a = list.get(i) >> b;
				if (a % 2 == 0)
					elementsWitBitNotSet.add(i);
			}
			if (elementsWitBitNotSet.size() == 0) {
				pow = pow * 2;
				continue;
			}

			int count = 1;
			for (int i = 1; i < elementsWitBitNotSet.size(); i++) {
				int curr = elementsWitBitNotSet.get(i);
				int prev = elementsWitBitNotSet.get(i - 1);
				if (curr - prev == 1) {
					count++;
				} else {
					numOfSubArrWithBitNotSet += count * (count + 1) / 2;
					count = 1;
				}
			}
			numOfSubArrWithBitNotSet += count * (count + 1) / 2;
			int numOfSetBitElements = totalSubArrays - numOfSubArrWithBitNotSet;
			sum += numOfSetBitElements * pow;
			pow = pow * 2;

		}
		return sum;
	}

}
