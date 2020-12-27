package com.marcelo.ZSSN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.ZSSN.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
