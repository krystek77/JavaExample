package com.wronakrystian.otopralnia.domains;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "washer")
public class Washer extends Machine {
	
	private String washingSpeed;
	
	public Washer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Washer(String type, BigDecimal price, String washingSpeed) {
		super(type, price);
		this.washingSpeed = washingSpeed;
		// TODO Auto-generated constructor stub
	}

	public String getWashingSpeed() {
		return washingSpeed;
	}

	public void setWashingSpeed(String washingSpeed) {
		this.washingSpeed = washingSpeed;
	}

	@Override
	public String toString() {
		return "Washer [washingSpeed=" + washingSpeed + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getPrice()=" + getPrice() + ", getVoltages()=" + getVoltages() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

	
	
	
	
}
