package com.marcelo.ZSSN.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcelo.ZSSN.model.Item;
import com.marcelo.ZSSN.model.ItemType;
import com.marcelo.ZSSN.model.Survivor;
import com.marcelo.ZSSN.repository.ItemTypeRepository;
import com.marcelo.ZSSN.repository.SurvivorRepository;

@RestController
public class TradeController {
	
	@Autowired
    private SurvivorRepository survivorRepository;
	
	@Autowired
    private ItemTypeRepository itemTypeRepository;
	
    @RequestMapping(value = "/trade/inventory/{survivor_id}", method = RequestMethod.GET)
    public List<Item> inventory(@PathVariable Long survivor_id) {
    	Survivor survivor = survivorRepository.findById(survivor_id).get();
    	return survivor.getInventory();
    }
	
    @RequestMapping(value = "/trade", method = RequestMethod.POST)
    public ResponseEntity<String> trade(@RequestBody JsonNode json) {
    	long survivor_id = json.get("survivor_id").asLong();
    	long trader_id = json.get("trader_id").asLong();
    	
    	JsonNode offered_items = json.path("offered_items");
    	JsonNode desired_items = json.path("desired_items");
    	

    	
    	ArrayList<Item> items1 = new ArrayList<Item>();
    	ArrayList<Item> items2 = new ArrayList<Item>();
    	
    	offered_items.forEach(item -> {
    		long itemType_id = item.get("itemType_id").asLong();
    		int amount = item.get("amount").asInt();
    		ItemType type = itemTypeRepository.findById(itemType_id).get();
    		Item aux = new Item();
    		aux.setItemType(type);
    		aux.setAmount(amount);
    		items1.add(aux);
    	});
    	
    	desired_items.forEach(item -> {
    		long itemType_id = item.get("itemType_id").asLong();
    		int amount = item.get("amount").asInt();
    		ItemType type = itemTypeRepository.findById(itemType_id).get();
    		Item aux = new Item();
    		aux.setItemType(type);
    		aux.setAmount(amount);
    		items2.add(aux);
    	});
    	
//    	System.out.println(items1);
//    	System.out.println(items2);
    	
    	if(!this.validateAmoutTrade(items1, items2)) {
    		return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
    	}
    	
//    	System.out.println(items1);
    	
    	
    	return new ResponseEntity<>("API ZSSN", HttpStatus.OK);
    }
    
    public boolean validateAmoutTrade(List<Item> item1, List<Item> item2){
    	int total1 = 0;
    	int total2 = 0;
    	
    	for(Item item : item1){
    		int item_points = item.getItemType().getPoints() * item.getAmount();
    		total1 = total1 + item_points;
        }
    	
    	for(Item item : item2){
    		int item_points = item.getItemType().getPoints() * item.getAmount();
    		total2 = total2 + item_points;
        }
    	 
    	System.out.println(total1);
    	System.out.println(total2);
    	
    	if(total1 == total2){
    		return true;
    	} else {
    		return false;
    	}
    	
    }

}
