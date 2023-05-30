package com.softra.dto;

public class Student {
	private int stuid;
	private String name;
	private int age;
	private String mob;
	private String addr;
	
	public Student() {}
	
	public Student(String name, int age, String mob) {
		super();
		this.name = name;
		this.age = age;
		this.mob = mob;
	}


	public Student(String name, int age, String mob, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.mob = mob;
		this.addr = addr;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	
	public int getStuid() {
		return stuid;
	}
	
	
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", age=" + age + ", mob=" + mob + ", addr=" + addr + "]";
	}

	
	
}
