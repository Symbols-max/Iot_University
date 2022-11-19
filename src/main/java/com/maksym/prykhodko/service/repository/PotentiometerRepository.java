package com.maksym.prykhodko.service.repository;

import com.maksym.prykhodko.model.Potentiometer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentiometerRepository extends JpaRepository<Potentiometer, Long> {

}
