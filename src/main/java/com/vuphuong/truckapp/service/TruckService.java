package com.vuphuong.truckapp.service;

import com.vuphuong.truckapp.entity.Truck;
import com.vuphuong.truckapp.repository.TruckRepositoty;
import org.springframework.stereotype.Service;

@Service
public class TruckService {
    private final TruckRepositoty truckRepositoty;
    public TruckService(TruckRepositoty truckRepositoty) {
        this.truckRepositoty = truckRepositoty;
    }

    public Truck getTruckById(Long id) {
        return truckRepositoty.findById(id).orElse(null);
    }

    public void saveTruck(Truck truck) {
        truckRepositoty.save(truck);
    }

    public void deleteTruckByID(Long id) {
        truckRepositoty.deleteById(id);
    }
}
