package com.gvsc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvsc.models.PersonModel;
import com.gvsc.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repo;

	public List<PersonModel> findAll() {
		return repo.findAll();
	}

	public Optional<PersonModel> findById(Long id) {
		return repo.findById(id);
	}

	public PersonModel save(PersonModel person) {
		return repo.save(person);
	}

	public PersonModel getOne(PersonModel person,Long id) {
		 PersonModel p = repo.getOne(id);
		 
		 if (p == null) {
				return null;
			}
			p.setAddress(person.getAddress());
			p.setName(person.getName());
			p.setCellphone(person.getCellphone());
			p.setCpf(person.getCpf());
			
			return p;
	}



}
