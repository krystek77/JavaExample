package com.wronakrystian.otopralnia.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Voltages")
public class VoltageOption {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="voltageId")
	private int id;
	private String value;
	private String note;
	
	@OneToMany(mappedBy = "voltage",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<MachineVoltage> machines;
	
	
	public VoltageOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoltageOption(String value, String note) {
		super();
		this.value = value;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoltageOption other = (VoltageOption) obj;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VoltageOption [id=" + id + ", value=" + value + ", note=" + note + ", machines=" + machines + "]";
	}
	
	
}
