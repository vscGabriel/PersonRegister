package com.gvsc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import com.gvsc.models.PersonModel;
import com.gvsc.repositories.PersonRepository;


@Controller("/")
public class PersonController {
	
	@Autowired
	private PersonRepository repo;
	
	@GetMapping("/list")
    public ModelAndView list(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");

        modelAndView.addObject("people", repo.findAll());
        
        return modelAndView;
    }
	
	@GetMapping("/sign-up")
	public ModelAndView signUp() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign-up");
        
		modelAndView.addObject("people", new PersonModel());
      
        return modelAndView;	
        }
	
	@PostMapping("/create")
	public String createPerson(@Valid @ModelAttribute PersonModel person ) {
		repo.save(person);	
		
		return "redirect:list";
		
	}


}
