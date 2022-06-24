package com.fis.ducnv.service;

import com.fis.ducnv.entities.Person;
import com.fis.ducnv.entities.role.UserRole;

import java.util.Set;

public interface PersonService {
    Person createUser(Person user, Set<UserRole> userRoles) throws Exception;

    Person addPerson(Person person);

    Person updatePerson(Person person);

    Set<Person> getPeople();

    Person getPerson(Long id);

    void deletePerson(Long id);
}
