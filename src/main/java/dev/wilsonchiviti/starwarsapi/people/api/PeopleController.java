package dev.wilsonchiviti.starwarsapi.people.api;

import dev.wilsonchiviti.starwarsapi.people.domain.Person;
import dev.wilsonchiviti.starwarsapi.people.service.query.PeopleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleQueryService peopleQueryService;

    @QueryMapping
    public List<Person> getPeople() {
        return peopleQueryService.findAll(1);
    }

    @QueryMapping
    public List<Person> getPeoplePage(@Argument int page) {
        return peopleQueryService.findAll(page);
    }

    @QueryMapping
    public Person getPerson(@Argument String url) {
        return peopleQueryService.findOne(url);
    }

    @QueryMapping
    public List<Person> searchPerson(@Argument String name) {
        return peopleQueryService.searchPerson(name, 1);
    }

    @QueryMapping
    public List<Person> searchPersonPage(@Argument String name, @Argument int page) {
        return peopleQueryService.searchPerson(name, page);
    }

}
