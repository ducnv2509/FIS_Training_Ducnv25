package com.fis.ducnv.service;

import com.fis.ducnv.entities.Person;
import com.fis.ducnv.entities.role.UserRole;

import java.util.Set;

public interface PersonService {
    public Person createUser(Person user, Set<UserRole> userRoles) throws Exception;
    public Person addPerson(Person person);
    public Person updatePerson(Person person);
    public Set<Person> getPeople();
    public Person getPerson(Long id);
    public void deletePerson(Long id);
}
