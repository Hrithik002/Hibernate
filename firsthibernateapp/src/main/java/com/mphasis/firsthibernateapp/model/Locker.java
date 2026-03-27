package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name= "lockers")
public class Locker {
	@Id
	@Column(name = "id", length = 10)
	private String id;
	@Column(name = "location", length = 10)
	private String location;
	@Column(name = "size", length = 10)
	private String size;
	
 public Locker() {
		// TODO Auto-generated constructor stub
}

public Locker(String id, String location, String size) {
	super();
	this.id = id;
	this.location = location;
	this.size = size;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Locker other = (Locker) obj;
	return Objects.equals(id, other.id);
}
 
}