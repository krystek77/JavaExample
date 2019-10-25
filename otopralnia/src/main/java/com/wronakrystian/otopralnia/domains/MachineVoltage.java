package com.wronakrystian.otopralnia.domains;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "MachinesVoltages")
public class MachineVoltage {

	@EmbeddedId
	private MachineVoltageId id;

	@ManyToOne
	@MapsId(value = "machineId")
	private Machine machine;
	@ManyToOne
	@MapsId(value = "voltageId")
	private VoltageOption voltage;
	@Enumerated(value = EnumType.STRING)
	private StatusTab status;
	
	public MachineVoltage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MachineVoltage(StatusTab status) {
		super();
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((machine == null) ? 0 : machine.hashCode());
		result = prime * result + ((voltage == null) ? 0 : voltage.hashCode());
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
		MachineVoltage other = (MachineVoltage) obj;
		if (machine == null) {
			if (other.machine != null)
				return false;
		} else if (!machine.equals(other.machine))
			return false;
		if (voltage == null) {
			if (other.voltage != null)
				return false;
		} else if (!voltage.equals(other.voltage))
			return false;
		return true;
	}

	public MachineVoltageId getId() {
		return id;
	}

	public void setId(MachineVoltageId id) {
		this.id = id;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public VoltageOption getVoltage() {
		return voltage;
	}

	public void setVoltage(VoltageOption voltage) {
		this.voltage = voltage;
	}

	public StatusTab getStatus() {
		return status;
	}

	public void setStatus(StatusTab status) {
		this.status = status;
	}

}
