package com.vuphuong.truckapp.repository;

import com.vuphuong.truckapp.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepositoty extends JpaRepository<Truck, Long> {
}
