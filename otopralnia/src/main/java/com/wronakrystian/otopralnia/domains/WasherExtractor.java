package com.wronakrystian.otopralnia.domains;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "washerExtractor")
public class WasherExtractor extends Machine {

	private String spinSpeed;

	public WasherExtractor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WasherExtractor(String type, BigDecimal price,String spinSpeed) {
		super(type, price);
		// TODO Auto-generated constructor stub
		this.spinSpeed = spinSpeed;
	}
	
	public String getSpinSpeed() {
		return spinSpeed;
	}

	public void setSpinSpeed(String spinSpeed) {
		this.spinSpeed = spinSpeed;
	}

	@Override
	public String toString() {
		return "WasherExtractor [spinSpeed=" + spinSpeed + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getPrice()=" + getPrice() + ", getVoltages()=" + getVoltages() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}
	
	

}
