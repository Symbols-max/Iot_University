package com.maksym.prykhodko.service;

import com.maksym.prykhodko.model.Potentiometer;
import com.maksym.prykhodko.service.repository.PotentiometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
