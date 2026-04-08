
package org.vaibhao;

import java.util.*;

class Employee {
	private int id;
	private String name;
	private int sal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
}

public class ArrayPojoDemo {
	public static void main(String[] args) {
		ArrayList al = new ArrayList<>();

		Employee emp1 = new Employee();
		emp1.setId(100);
		emp1.setName("Vaibhao");
		emp1.setSal(50000);

		Employee emp2 = new Employee();
		emp2.setId(200);
		emp2.setName("Amol");
		emp2.setSal(30000);

		Employee emp3 = new Employee();
		emp3.setId(100);
		emp3.setName("Ashoka");
		emp3.setSal(10000);

		al.add(emp1);
		al.add(emp2);
		al.add(emp3);

		for (Object obj : al) {
			Employee e = (Employee) obj;
			System.out.println("\n" + e.getId() + "\t\t" + e.getName() + "\t\t" + e.getSal() + "\n");
		}
	}
}
