package test1;

import java.io.Serializable;

public class Person1 implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
