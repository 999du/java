package org.ddd.annotation.example4_11.test;

import org.ddd.annatation.example4_11.annotation.Column;
import org.ddd.annatation.example4_11.annotation.ID;
import org.ddd.annotation.example4_11.annotation.Entity;


@Entity("People")
public class Person {
	
	@ID
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false, length = 16)
	private String name;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
