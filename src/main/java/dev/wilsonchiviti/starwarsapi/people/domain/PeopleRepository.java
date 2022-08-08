package dev.wilsonchiviti.starwarsapi.people.domain;

import dev.wilsonchiviti.starwarsapi.utils.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://swapi.dev/api/people", name = "StarWarsPeopleRepository")
interface PeopleRepository {

    @GetMapping
    Page<Person> getPeople(@RequestParam(name = "page") int page);

    @GetMapping
    Page<Person> searchPerson(@RequestParam(name = "search") String search,
                              @RequestParam(required = false, name = "page") int page);

}
