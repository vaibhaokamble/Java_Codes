package vaibhao.vk;

public class Employee1 {
	private int id;
	private String name;

	public Employee1() {

	}

	public Employee1(String name, int id, int sal) {
		this.name = name;
		this.id = id;
		this.sal = sal;
	}

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

	private int sal;

}