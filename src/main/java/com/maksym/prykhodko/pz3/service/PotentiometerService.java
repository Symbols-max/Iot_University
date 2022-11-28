package com.maksym.prykhodko.pz3.service;

import com.maksym.prykhodko.pz3.model.Potentiometer;
import com.maksym.prykhodko.pz3.service.repository.PotentiometerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotentiometerService {

    private final PotentiometerRepository potentiometerRepository;

    public PotentiometerService(PotentiometerRepository potentiometerRepository) {
        this.potentiometerRepository = potentiometerRepository;
    }

    public List<Potentiometer> list() {
        return potentiometerRepository.findAll();
    }

    public void add(Potentiometer potentiometer){
        potentiometerRepository.save(potentiometer);
    }

}
