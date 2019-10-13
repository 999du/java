package test;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
