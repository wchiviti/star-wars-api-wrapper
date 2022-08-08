package dev.wilsonchiviti.starwarsapi.people.domain;

import dev.wilsonchiviti.starwarsapi.utils.Page;
import feign.RequestLine;
import lombok.val;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@FeignClient(url = "https://swapi.dev/api/people", name = "StarWarsPeopleRepository")
interface PeopleRepository {

    @GetMapping
    Page<Person> getPeople(@RequestParam(name = "page") int page);

    default Person getPerson(URI baseUri){
        val restTemplate = new RestTemplate();
        return restTemplate.getForObject(baseUri, Person.class);
    }

    @GetMapping
    Page<Person> searchPerson(@RequestParam(name = "search") String search,
                              @RequestParam(required = false, name = "page") int page);

}
