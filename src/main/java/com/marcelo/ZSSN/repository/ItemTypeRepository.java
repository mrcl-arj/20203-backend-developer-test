package com.marcelo.ZSSN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.ZSSN.model.ItemType;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long>{

}
