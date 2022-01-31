package com.scaler.subsequence;

import java.util.ArrayList;

public class SumOfAllSubArrayXOR {

	public SumOfAllSubArrayXOR() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("sor " + (1^2^3));
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		solve(A);
	}
	
	public static int solve(ArrayList<Integer> A) {
        int N = A.size();
        int mod = (int)Math.pow(10,9);
        mod += 7;
        int pn = (int)Math.pow(2,N);
        int sum = 0;
        for(int i = 1; i<pn; i++){
            int xor = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<N;j++){
                int check = i&(1<<j);
                if(check>0){
                    xor = xor^A.get(j);
                    sb.append(A.get(j) + " ");
                }
            }
            sum += xor; //(xor%mod);
            System.out.println("subset-"+i + " [" + sb.toString() + "], xor : " + xor + ", sum= " + sum );
        }
        System.out.println( "sum= " + sum);
        return (sum%mod);
    }

}
