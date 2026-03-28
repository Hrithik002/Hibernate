package com.mphasis.firsthibernateapp.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
 
@Entity
@Table(name="creditaccounts")
public class CreditAccount extends Account {
	@Column(name="creditlimit")
	private double creditlimit;
 
	public CreditAccount() {
		// TODO Auto-generated constructor stub
	}
 
	public double getCreditlimit() {
		return creditlimit;
	}
 
	public void setCreditlimit(double creditlimit) {
		this.creditlimit = creditlimit;
	}
	
	
 
}
 