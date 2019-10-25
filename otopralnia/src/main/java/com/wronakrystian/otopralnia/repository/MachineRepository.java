package com.wronakrystian.otopralnia.repository;

import org.springframework.data.repository.CrudRepository;

import com.wronakrystian.otopralnia.domains.Machine;

public interface MachineRepository extends CrudRepository<Machine, Integer> {

}
