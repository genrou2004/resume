package com.resume.repository;

import com.resume.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 6/29/17.
 */
public interface PersonRepository extends CrudRepository<Person,Integer> {
}
