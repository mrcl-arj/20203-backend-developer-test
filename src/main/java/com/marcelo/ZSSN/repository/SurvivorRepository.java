package com.marcelo.ZSSN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcelo.ZSSN.model.Survivor;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long>{
	
	@Query(value = "SELECT COUNT(id) AS quantity FROM survivor where zombie=true", nativeQuery=true)
    Long zombiesPercent();
	
	@Query(value = "SELECT COUNT(id) AS quantity FROM survivor where zombie=false", nativeQuery=true)
    Long survivorsPercent();
	
	@Query(value = "SELECT item_type.name, avg(amount) FROM item JOIN item_type on item.item_type_id=item_type.id JOIN survivor ON survivor.id=item.survivor_id where zombie=false group by item_type_id", nativeQuery=true)
	List<String> averageAmountItem();
	
	@Query(value = "SELECT ISNULL(SUM(points), 0 ) as total FROM survivor JOIN item ON survivor.id=item.survivor_id JOIN item_type ON item.item_type_id=item_type.id WHERE zombie=true", nativeQuery=true)
	Long pointsLost();
	
}
