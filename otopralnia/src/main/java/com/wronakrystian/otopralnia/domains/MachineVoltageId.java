package com.wronakrystian.otopralnia.domains;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MachineVoltageId implements Serializable {
	
	private static final long serialVersionUID = -1132967501016543901L;
	
	@Column(name="machineId")
	private int machineId;
	@Column(name="machineId")
	private int voltageId;
	
	public MachineVoltageId() {
		super();
	}

	public MachineVoltageId(int machineId, int voltageId) {
		super();
		this.machineId = machineId;
		this.voltageId = voltageId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getMachineId() {
		return machineId;
	}

	public int getVoltageId() {
		return voltageId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + machineId;
		result = prime * result + voltageId;
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
		MachineVoltageId other = (MachineVoltageId) obj;
		if (machineId != other.machineId)
			return false;
		if (voltageId != other.voltageId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MachineVoltageId [machineId=" + machineId + ", voltageId=" + voltageId + "]";
	}

}
