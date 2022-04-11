package com.groep3.bestel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.groep3.bestel.entities.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}