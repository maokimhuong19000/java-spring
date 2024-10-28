package com.setec.coffee_shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setec.coffee_shop.entities.Booked;

public interface BookedRepo extends JpaRepository<Booked, Integer> {
	
}
