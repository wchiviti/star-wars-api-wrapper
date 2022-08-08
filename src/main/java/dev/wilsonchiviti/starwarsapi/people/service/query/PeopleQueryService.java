package dev.wilsonchiviti.starwarsapi.people.service.query;

import dev.wilsonchiviti.starwarsapi.people.domain.Person;

import java.util.List;

/**
 * @author wilson
 */
public interface PeopleQueryService {

    List<Person> findAll(int page);

    Person findOne(String url);

    List<Person> searchPerson(String name, int page);

}
