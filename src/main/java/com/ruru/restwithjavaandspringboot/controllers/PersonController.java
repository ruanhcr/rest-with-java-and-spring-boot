package com.ruru.restwithjavaandspringboot.controllers;

import com.ruru.restwithjavaandspringboot.model.PersonModel;
import com.ruru.restwithjavaandspringboot.services.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public PersonModel findById(@PathVariable(value = "id") Long id){
        return personService.findById(id);
    }

    @GetMapping()
    public List<PersonModel> findAll(){
        return personService.findAll();
    }

    @PostMapping()
    public PersonModel create(@RequestBody PersonModel person){
        return personService.create(person);
    }

    @PutMapping()
    public PersonModel update(@RequestBody PersonModel person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}