package com.scaler.subarray;

import java.util.ArrayList;

import com.google.strings.Util;

public class PrintAllSubArrays {

	public PrintAllSubArrays() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = Util.getArrayList(5);
		A.clear();
		A.add(5);
		A.add(1);
		A.add(6);
		subArrays(A);
	}
	
	public static void subArrays(ArrayList A) {
		int N = A.size();
		int sum = 0;
		int count = 0;
		for(int i=0;i<N;i++) {
			int xor = 0;
			StringBuilder sb = new StringBuilder();
			for(int j=i;j<N;j++) {
				sb.append(A.get(j) + " ");
				xor = xor^(int)A.get(j);
				sum += xor;
				System.out.println("subarray count-" + (++count) + " [" + sb.toString() + "], xor= " + xor + ", sum= " + sum );
			}
		}
	}
	
	public static int bitwiseOr(ArrayList<Integer> A) {

		long sum = 0;
		int prev[] = new int[32]; // Creating array of 32 Bits which will be fill filled with 1 and not 0
		int mod = 1000000007;
		
		for (int i = 1; i <= A.size(); i++) {
			int sum2 = A.get(i - 1);
			 System.out.println("sum2 " + sum2 + ", sum = " + sum );
			for (int j = 0; j < 32; j++) {
				long pow = (1 << j);// Left shifting 1, j times
				System.out.println("pow -- " + pow);
				if ((sum2 & pow) != 0) {// if sum2 & pow != 0 than we add we add i in the array
					sum = (sum + (pow * i) % mod) % mod; // calculating sum using mod
					prev[j] = i; // add i in the array
				} else if (prev[j] != 0) {
					System.out.println("prev[j] -- " + prev[j]);
					sum = (sum + (pow * prev[j]) % mod) % mod;// if prev[j] != 0 than we calculate sum again.
				}
				System.out.println("sum2 " + sum2 + ", sum = " + sum + " pow " + pow);
			}
		}

		return (int) (sum % mod); // taking mod for all subarray sum
	}

	public static int solve(ArrayList<Integer> A) {
        int N = A.size();
        long mod = (long)Math.pow(10,9);
        mod += 7;
        long[] prefix = new long[N+1];
        for(int i=0;i<N;i++){
            prefix[i+1] = prefix[i]+A.get(i);
        }
        long sum = 0;
        for(int i = 1; i<=N; i++){                        
            for(int j=i;j<=N;j++){                
                //bor = (bor|A.get(j));  
                long bor = prefix[j]-prefix[i-1];
                sum += (bor%mod);  
                sum = (sum%mod);   
                System.out.println("bor " + bor + ", sum= " + sum );
            }            
        }
        return (int)(sum%mod);
    }
	
	public static int solve2(ArrayList<Integer> A) {
        int N = A.size();
        long mod = (long)Math.pow(10,9);
        mod += 7;
        
        long sum = 0;
        for(int i = 0; i<N; i++){
        	StringBuilder sb = new StringBuilder();
            int xor = 0;            
            for(int j=i;j<N;j++){  
            	sb.append(A.get(j)).append(" ");
                xor = xor^A.get(j);  
                sum += (xor%mod);  
                sum = (sum%mod);  
                System.out.println("subset-"+i + " [" + sb.toString() + "], xor : " + xor + ", sum= " + sum );
            }            
        }
        return (int)(sum%mod);
    }
	
	private static void solve1(ArrayList<Integer> A) {
		int N = A.size();
		int count = 0;
		for(int i=0; i<N;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=i;j<N;j++) {
				sb.append(A.get(j)).append(" ");
				System.out.println("subArray-" + (++count) + " : "+ sb.toString());
			}
		}
		
	}

}
