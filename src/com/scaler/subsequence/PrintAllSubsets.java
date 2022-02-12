package com.scaler.subsequence;

import java.util.ArrayList;

import com.google.strings.Util;

public class PrintAllSubsets {

	public PrintAllSubsets() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int[] arr = { 12, 10, 28, 37, 43, 40, 14, 12, 48 };
		System.out.println(solve(arr));
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> nums = Util.getArrayList(3);
		subsets(nums, 0, new ArrayList<Integer>(), res);
		Util.printList(nums);
	}

	public static void subsets(ArrayList<Integer> nums, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res ){
		if(start >= nums.size())
			return;
		
		for(int i=start; i<nums.size();i++) {
			list.add(nums.get(i));
			res.add(new ArrayList<>(list));
			Util.printList(list);
			subsets(nums, i+1, list, res);
			list.remove(list.get(list.size()-1));
			//Util.printList(list);
		}
	}
	
	public static int solve(int[] A) {
        int n = A.length;
        int c1 = 0, c2 = 0;
        int i=0;
        while(i<n){           
            if(A[i]%2==0) {
                i++;
                continue;
            }            
            while(i<n && (A[i]%2==1)) i++;
            c1++;
            while(i<n && (A[i]%2==0)) i++;
            c1++;
        }
        i=0;
        while(i<n){           
            if(A[i]%2==1) {
                i++;
                continue;  
            }                      
            while(i<n && (A[i]%2==0)) i++;
            c2++;
            while(i<n && (A[i]%2==1)) i++;
            c2++;
        }        
        return Math.max(c1,c2);
    }
}
