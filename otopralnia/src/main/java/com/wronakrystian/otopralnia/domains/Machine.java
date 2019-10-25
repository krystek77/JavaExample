package com.wronakrystian.otopralnia.domains;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()
@Table(name = "Machines")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "MACHINE_TYPE",discriminatorType = DiscriminatorType.STRING)
public abstract class Machine {

	@Id
	@TableGenerator(name = "myGenerator",
	table = "tabelka_z_identyfikatorami",
	pkColumnName = "nazwa",
	valueColumnName = "lastValue",
	pkColumnValue = "id_maszyny"
	)
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.TABLE)
	@Column(name = "machineId")
	private int id;
	private String type;
	private BigDecimal price;
	
	
	@OneToMany(mappedBy = "machine",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MachineVoltage> voltages;

	
	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Machine(String type, BigDecimal price) {
		super();
		this.type = type;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<MachineVoltage> getVoltages() {
		return voltages;
	}

	public void setVoltages(List<MachineVoltage> voltages) {
		this.voltages = voltages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Machine other = (Machine) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", type=" + type + ", price=" + price + ", voltages=" + voltages + "]";
	}
	
	
	

}
