package com.qa.quickstart.JunitProj;

public class Functions {
	
	
	public int add(int v1,int v2) {
		int sum = 0;
		sum = v1 + v2;
		return sum;
	}
	
	public int subtract(int v1, int v2) {
		int sum = 0;
		sum = v1 - v2;
		return sum;
	}
	
	public int multiply(int v1, int v2) {
		int sum = 0;
		sum = v1 * v2;
		return sum;
	}
	
	public double divide(int v1, int v2) {
		double sum = 0;
		sum = (double)v1 / (double)v2;
		return sum;
	}
	
	public int mod(int v1, int v2) {
		int sum = 0;
		sum = v1 % v2;
		return sum;
	}
	
	public int power(int v1, int v2) {
		
		return (int) Math.pow(v1, v2);
	}
	
	public int swtich(boolean screenOn) {
		if(screenOn) {
			return 1;
		}
		
		
		return 0;
	}

}
