package com.mphasis.firsthibernateapp.model;
 
import java.util.Objects;
 
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
 
@Entity
@Table(name="vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vtype",discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
	@Id
	@Column(name="id",length=10)
	private String id;
	@Column(name="manufacturer",length=20)
	private String manufacturer;
	public Vehicle() {
	
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String id, String manufacturer) {
	
		this.id = id;
		this.manufacturer = manufacturer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
		Vehicle other = (Vehicle) obj;
		return Objects.equals(id, other.id);
	}
 
	
}
 