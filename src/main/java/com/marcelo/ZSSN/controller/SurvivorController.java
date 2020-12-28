package com.marcelo.ZSSN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.marcelo.ZSSN.model.Item;
import com.marcelo.ZSSN.model.Survivor;
import com.marcelo.ZSSN.repository.ItemRepository;
import com.marcelo.ZSSN.repository.SurvivorRepository;

@RestController
public class SurvivorController {
	
	@Autowired
    private SurvivorRepository survivorRepository;
	
	@Autowired
    private ItemRepository itemRepository;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> index() {
    	return new ResponseEntity<>("API ZSSN", HttpStatus.OK);
    }
	
    @RequestMapping(value = "/survivor", method = RequestMethod.GET)
    public List<Survivor> getAll() {
    	return survivorRepository.findAll();
    }
    
    @RequestMapping(value = "/survivor/save", method =  RequestMethod.POST)
    public Survivor save(@RequestBody Survivor survivor){
    	survivorRepository.save(survivor);
    	
    	List<Item> itens = survivor.getInventory();
    	
    	for(Item item : itens){
    		item.setSurvivor(survivor);
    		itemRepository.save(item);
        }
        return survivor;
    }
    
    @RequestMapping(value = "/survivor/updateLocation", method =  RequestMethod.POST)
    public ResponseEntity<String> updateLocation(@RequestBody JsonNode json){
    	
    	long survivor_id = json.get("id").asLong();
    	float latitude = json.get("latitude").floatValue();
    	float longitude = json.get("longitude").floatValue();
    	
    	try {
    		Survivor survivor = survivorRepository.findById(survivor_id).get();
    		survivor.setLatitude(latitude);
    		survivor.setLongitude(longitude);
    		survivorRepository.save(survivor);
    		
    		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
    	}	
    }
    
    @RequestMapping(value = "/survivor/infected", method =  RequestMethod.POST)
    public ResponseEntity<String> infected(@RequestBody JsonNode json){
    	
    	long survivor_id = json.get("survivor_id").asLong();
    	long infected_id = json.get("infected_id").asLong();
    	
    	try {
    		Survivor survivor = survivorRepository.findById(survivor_id).get();
    		survivor.setInfected(survivor.getInfected()+1);
    		if(survivor.getInfected()>2)
    			survivor.setZombie(true);
    		
    		survivorRepository.save(survivor);
    		
    		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
    	}	
    }


}
