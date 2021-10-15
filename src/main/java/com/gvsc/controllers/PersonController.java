package com.gvsc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.engine.AttributeName;

import com.gvsc.models.PersonModel;
import com.gvsc.repositories.PersonRepository;
import com.gvsc.services.PersonService;


@Controller("/")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping("/list")
    public ModelAndView list(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");

        modelAndView.addObject("people", service.findAll());
        
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
	public String createPerson(@Valid @ModelAttribute PersonModel person, BindingResult result, RedirectAttributes redirectAtt) {
		
		if(result.hasErrors()) {
			return "redirect:/sign-up";
		}
		
		service.save(person);	
		
		redirectAtt.addFlashAttribute("message", "Success create person.");
		
		return "redirect:/list";
		
	}


}
