package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Bus;

public interface IBusRepository extends JpaRepository<Bus, Integer>{

}
