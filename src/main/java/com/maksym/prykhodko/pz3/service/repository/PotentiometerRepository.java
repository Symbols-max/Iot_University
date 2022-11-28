package com.maksym.prykhodko.pz3.service.repository;

import com.maksym.prykhodko.pz3.model.Potentiometer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentiometerRepository extends JpaRepository<Potentiometer, Long> {

}
