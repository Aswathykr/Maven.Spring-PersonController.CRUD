package com.crud.io.zipcoder.crudapp.repository;

import com.crud.io.zipcoder.crudapp.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
