package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "NAME")
	private String name;
	private String Address;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "MyEntity [id=" + id + ", name=" + name + ", Address=" + Address + "]";
	}
	public MyEntity( String name, String address) {
		super();
		
		this.name = name;
		Address = address;
	}

	public MyEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
