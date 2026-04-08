package org.vaibhao;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList al = new ArrayList<>();
		al.add(100);
		al.add(500);
		al.add(400);
		al.add(200);
		al.add(300);
		System.out.println("Before Sorting");
		System.out.println("____________________");
		for (Object obj : al) {
			System.out.println(obj);
		}
		for (int i = 0; i < al.size(); i++) {
			for (int j = (i + 1); j < al.size(); j++) {
				Object prev = al.get(i);
				Object next = al.get(j);
				if ((int) prev > (int) next) {
					Object temp = al.get(i);
					al.set(i, next);
					al.set(j, temp);
				}
			}
		}
		System.out.println("\nDisplay The Element After Sorting");
		System.out.println("__________________________________________");
		for (Object obj : al) {
			System.out.println(obj);
		}
	}
}