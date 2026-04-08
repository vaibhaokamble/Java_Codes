package com.vaibhao;

import java.util.Scanner;

public class PowerApp {

	public static void main(String[] args) {
		Scanner v = new Scanner(System.in);
		int base,index,p=1;
		System.out.println("Enter the base and index");
		base = v.nextInt();
		index= v.nextInt();
		for(int i=1; i<index; i++) {
			p=p*base;
		}
		System.out.println("The  Power is : "+p);
	}

}
