package com.mphasis.firsthibernateapp.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
 
 
@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	@Column(name="steeringHandelType",length=20)
	 String steeringHandleType;
 
	public FourWheeler() {
		
		// TODO Auto-generated constructor stub
	}
 
 
	public String getSteeringHandleType() {
		return steeringHandleType;
	}
 
	public void setSteeringHandleType(String steeringHandleType) {
		this.steeringHandleType = steeringHandleType;
	}
 
	
	
 
}
 