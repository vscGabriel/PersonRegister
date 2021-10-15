package com.gvsc.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvsc.models.PersonModel;
import com.gvsc.services.PersonService;

@RestController
public class PersonResource {

	@Autowired
	private PersonService service;

	@GetMapping("/get")
	public List<PersonModel> getPerson() {
		return service.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<PersonModel> getPersonId(@PathVariable("id") Long id) {

		return service.findById(id);
	}

	@PostMapping("/post")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonModel createPerson(@RequestBody PersonModel person) {
		return service.save(person);
	}

	@PutMapping("/update/{id}")
	public PersonModel updatePerson(@RequestBody PersonModel person, @PathVariable Long id) {
		return service.save(service.getOne(person,id));
	}

	
	
}
