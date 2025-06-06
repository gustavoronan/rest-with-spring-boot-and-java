package br.com.gustavoronan.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoronan.model.Person;
import br.com.gustavoronan.request.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController implements Serializable{
	 
	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Person findById (@PathVariable("id")String id) {
		Person person = service.findById(id);
		return person;
	}
	
	@GetMapping("/lista")
	public List<Person> findAll () {
		return service.findAll();
	}
	
	@RequestMapping( value = "/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Person create (@RequestBody Person person) {
		return service.create(person);
	}
	
	@RequestMapping( value = "/update",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.DELETE
			)
	public void delete (@PathVariable("id")String id) {
		  service.delete(id);
		
	}
}
