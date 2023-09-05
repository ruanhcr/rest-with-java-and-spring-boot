package com.ruru.restwithjavaandspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ruru.restwithjavaandspringboot.model.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {}