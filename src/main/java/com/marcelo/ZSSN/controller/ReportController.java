package com.marcelo.ZSSN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.ZSSN.repository.SurvivorRepository;

@RestController
public class ReportController {

	@Autowired
    private SurvivorRepository survivorRepository;
	
    @RequestMapping(value = "/report/zombiesPercent", method = RequestMethod.GET)
    public ResponseEntity<String> zombiesPercent() {
    	Long zombies = survivorRepository.zombiesPercent();
		int all = survivorRepository.findAll().size();
    	double total = (zombies*100)/all;
    	String response = Double.toString(total) + "% infected";
    	return new ResponseEntity<>(response , HttpStatus.OK);
    }
	
    @RequestMapping(value = "/report/survivorsPercent", method = RequestMethod.GET)
    public ResponseEntity<String> survivorsPercent() {
    	Long survivors = survivorRepository.survivorsPercent();
		int all = survivorRepository.findAll().size();
    	double total = (survivors*100)/all;
    	String response = Double.toString(total) + "% not infected";
    	return new ResponseEntity<>(response , HttpStatus.OK);
    }
    
    @RequestMapping(value = "/report/averageAmountItem", method = RequestMethod.GET)
    public ResponseEntity<String> averageAmountItem() {
    	List<String> total = survivorRepository.averageAmountItem();
    	String response = "";
    	for(String t : total){
    		response = response + t + " | ";
    		System.out.println(t);
    	}
    	return new ResponseEntity<>(response , HttpStatus.OK);
    }
    
    @RequestMapping(value = "/report/pointsLost", method = RequestMethod.GET)
    public ResponseEntity<String> pointsLost() {
    	Long total = survivorRepository.pointsLost();
    	String response = Long.toString(total) + " points lost";
    	return new ResponseEntity<>(response , HttpStatus.OK);
    }
    

}
