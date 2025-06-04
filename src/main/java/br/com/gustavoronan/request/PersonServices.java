package br.com.gustavoronan.request;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for(int i = 1; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	

	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nome" + i);
		person.setLastName("Sobrenome" + i);
		person.setAdress("Endereço" + i);
		if(person.getId() % 2 == 0) {
			person.setGender("Male"+ i);
		}else {			
			person.setGender("Female" + i);
		}
		return person;
	}
	
}
