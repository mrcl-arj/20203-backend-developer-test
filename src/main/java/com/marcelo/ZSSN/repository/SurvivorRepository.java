package com.marcelo.ZSSN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.ZSSN.model.Survivor;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long>{

}
