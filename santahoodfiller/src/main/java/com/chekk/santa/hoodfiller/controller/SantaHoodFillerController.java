package com.chekk.santa.hoodfiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chekk.santa.hoodfiller.Entity.SantaHoodFillerRequest;
import com.chekk.santa.hoodfiller.Entity.SantaHoodFillerResponse;
import com.chekk.santa.hoodfiller.service.SantaHoodFillerService;





@RestController
public class SantaHoodFillerController {

	@Autowired
	SantaHoodFillerService santaHoodFillerService;
	
	
	@PostMapping("/hoodfiller")
	public ResponseEntity<SantaHoodFillerResponse> getMinNumberItem(@RequestBody SantaHoodFillerRequest santaHoodFillerRequest) {
		List<Integer> minimumPresents = santaHoodFillerService.minimumPresents(santaHoodFillerRequest.getPresent_weights(), santaHoodFillerRequest.getHood_capacity());
		SantaHoodFillerResponse santaHoodFillerResponse= new SantaHoodFillerResponse();
		santaHoodFillerResponse.setMinimunPresents(minimumPresents);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(santaHoodFillerResponse);
	}

}
