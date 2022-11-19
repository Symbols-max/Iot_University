package com.maksym.prykhodko.controller;

import com.maksym.prykhodko.model.Potentiometer;
import com.maksym.prykhodko.service.PotentiometerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/potentiometers")
public class PotentiometerController {

    private final PotentiometerService potentiometerService;

    public PotentiometerController(PotentiometerService potentiometerService) {
        this.potentiometerService = potentiometerService;
    }

    @GetMapping
    public String getPotentiometers() {

        List<Potentiometer> potentiometers = potentiometerService.list();

        return potentiometers.toString();
    }

    @PostMapping
    public ResponseEntity<Potentiometer> createPotentiometer(@RequestParam("name") String name,
                                                             @RequestParam("value") Integer value) {

        Potentiometer potentiometer = new Potentiometer(name, value);

        potentiometerService.add(potentiometer);

        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(potentiometer);
    }
}

