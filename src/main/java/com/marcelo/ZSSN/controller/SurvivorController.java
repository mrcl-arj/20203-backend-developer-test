package com.marcelo.ZSSN.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurvivorController {
	
    @RequestMapping(value = "/survivor", method = RequestMethod.GET)
    public ResponseEntity<String> getAll() {
    	return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
