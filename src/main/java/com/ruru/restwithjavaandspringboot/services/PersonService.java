package com.ruru.restwithjavaandspringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruru.restwithjavaandspringboot.exceptions.ResourceNotFoundException;
import com.ruru.restwithjavaandspringboot.model.PersonModel;
import com.ruru.restwithjavaandspringboot.repository.PersonRepository;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<PersonModel> findAll() {
        logger.info("Finding all persons!");
        return personRepository.findAll();
    }

    public PersonModel findById(Long id) {
        logger.info("Finding one person!");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for these id"));
    }

    public PersonModel create(PersonModel person) {
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public PersonModel update(PersonModel person) {
        logger.info("Updating one person!");
        PersonModel entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for these id"));
        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        PersonModel entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for these id"));
        personRepository.delete(entity);
    }

}