package com.telusko.SpringMVCDemo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringMVCDemo.dao.AlienRepository;
import com.telusko.SpringMVCDemo.model.Alien;


@RestController
public class AlienController {
	
	@Autowired
	AlienRepository alienRepository;
	
	//@GetMapping("aliens")
	@GetMapping(path="aliens",produces = {"application/xml"})//this is for xml format
	public List<Alien> getAliens() {
		List<Alien> aliens=alienRepository.findAll();
		return aliens;
	}
	
	
	@GetMapping("aliens/{aid}")
	public  Alien getAlienByAid(@PathVariable("aid") int aid) {
		Alien alien=alienRepository.findById(aid).orElse(new Alien(0,""));
		return alien;
	}
	
//	@PostMapping("alien")
//	public String addAlien(Alien a) {
//		alienRepository.save(a);
//		return "Successfully Added";
//	}

//	@PostMapping("alien")
//	public Alien addAlien(@RequestBody Alien a) {
//		alienRepository.save(a);
//		return a;
//	}
	
	@PostMapping(path="alien", consumes = {"application/json"})
	public Alien addAlien(@RequestBody Alien a) {
		alienRepository.save(a);
		return a;
	}
	
}
