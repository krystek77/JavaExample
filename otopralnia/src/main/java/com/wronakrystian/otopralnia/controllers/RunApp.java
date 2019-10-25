package com.wronakrystian.otopralnia.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wronakrystian.otopralnia.domains.Machine;
import com.wronakrystian.otopralnia.domains.MachineVoltage;
import com.wronakrystian.otopralnia.domains.MachineVoltageId;
import com.wronakrystian.otopralnia.domains.StatusTab;
import com.wronakrystian.otopralnia.domains.VoltageOption;
import com.wronakrystian.otopralnia.domains.Washer;
import com.wronakrystian.otopralnia.domains.WasherExtractor;
import com.wronakrystian.otopralnia.repository.MachineRepository;

@Component
public class RunApp {
	
	private MachineRepository repository;
	
	@Autowired
	public RunApp(MachineRepository repository) {
		super();
		this.repository = repository;
	}
	public void setRepository(MachineRepository repository) {
		this.repository = repository;
	}
	
	public void run() {
		System.out.println("RUN APP");
		VoltageOption v1 = new VoltageOption("230V/50Hz","Zasilanie jednofazowe");
		VoltageOption v2 = new VoltageOption("380-415V/50Hz","Zasilanie trójfazowe");
		VoltageOption v3 = new VoltageOption("220-240V/1/60Hz","Zasilanie jednofazowe amerykańskie");
		VoltageOption v4 = new VoltageOption("230V/3/50Hz","Zasilanie trójfazowe liniowe");

		Machine m1 = new Washer("PBE-08",new BigDecimal("11000"),"45");
		Machine m2 = new Washer("PBE-15",new BigDecimal("12500"),"45");
		Machine m3 = new WasherExtractor("RX105",new BigDecimal("16500.00"),"760");
		Machine m4 = new WasherExtractor("RX135",new BigDecimal("23000.00"),"760");
		Machine m5 = new Washer("PBE-08",new BigDecimal("10000.00"),"50");
	
		
		MachineVoltage machineVoltage1 = new MachineVoltage();
		MachineVoltage machineVoltage2 = new MachineVoltage();
		MachineVoltage machineVoltage3 = new MachineVoltage();
		MachineVoltage machineVoltage4 = new MachineVoltage();
		//
		machineVoltage1.setId(new MachineVoltageId(m1.getId(), v1.getId()));
		machineVoltage1.setStatus(StatusTab.STANDARD);
		machineVoltage2.setId(new MachineVoltageId(m1.getId(), v2.getId()));
		machineVoltage2.setStatus(StatusTab.OPTION_EXTRA_COSTS);
		machineVoltage3.setId(new MachineVoltageId(m1.getId(), v3.getId()));
		machineVoltage3.setStatus(StatusTab.OPTION_NO_COSTS);
		//
		machineVoltage4.setId(new MachineVoltageId(m4.getId(), v4.getId()));
		machineVoltage4.setStatus(StatusTab.STANDARD);
		
		List<MachineVoltage> voltages1 = new ArrayList<MachineVoltage>();
		voltages1.add(machineVoltage1);
		voltages1.add(machineVoltage2);
		voltages1.add(machineVoltage3);
		m1.setVoltages(voltages1);
		
		machineVoltage1.setMachine(m1);
		machineVoltage1.setVoltage(v1);
		machineVoltage2.setMachine(m1);
		machineVoltage2.setVoltage(v2);
		machineVoltage3.setMachine(m1);
		machineVoltage3.setVoltage(v3);
		
		List<MachineVoltage> voltages2 = new ArrayList<MachineVoltage>();
		voltages2.add(machineVoltage4);
		m4.setVoltages(voltages2);
		
		machineVoltage4.setMachine(m4);
		machineVoltage4.setVoltage(v4);
		

		repository.save(m1);
		repository.save(m2);
		repository.save(m3);
		repository.save(m4);
		repository.save(m5);
		
		System.out.println("MACHINES ==================================");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		List<Machine> machines = repository.findByType("PBE-08");
		machines.forEach(System.out::println);
		
		Iterator<Machine> it = machines.iterator();
		while(it.hasNext()) {
			Machine m = it.next();
			System.out.println(m);
		}
		
		Iterable<Machine> machinesByPrices = repository.findByPrice(new BigDecimal("12500"));
		Iterator<Machine> it2 = machinesByPrices.iterator();
		System.out.println("BY PRICE ======= ");
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	
		
		
		
	}
}
