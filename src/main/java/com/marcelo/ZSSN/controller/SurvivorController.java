package com.marcelo.ZSSN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    	//return new ResponseEntity<>("OK", HttpStatus.OK);
    	return survivorRepository.findAll();
    }
    
    @RequestMapping(value = "/survivor/save", method =  RequestMethod.POST)
    public Survivor create(@RequestBody Survivor survivor){
    	survivorRepository.save(survivor);
    	
    	List<Item> itens = survivor.getInventory();
    	
    	for(Item item : itens){
    		item.setSurvivor(survivor);
    		itemRepository.save(item);
        }
        return survivor;
    }

}
