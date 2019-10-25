package com.wronakrystian.otopralnia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wronakrystian.otopralnia.domains.Machine;

public interface MachineRepository extends CrudRepository<Machine, Integer> {
	public List<Machine> findByType(String type);
	public Iterable<Machine> findByPrice(BigDecimal price);
}
