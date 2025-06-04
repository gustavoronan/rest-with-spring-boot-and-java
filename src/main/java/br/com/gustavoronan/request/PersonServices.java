package br.com.gustavoronan.request;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.gustavoronan.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding a Person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Gustavo");
		person.setLastName("Ronan");
		person.setAdress("Foz do Iguaçu - Parana - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
}
