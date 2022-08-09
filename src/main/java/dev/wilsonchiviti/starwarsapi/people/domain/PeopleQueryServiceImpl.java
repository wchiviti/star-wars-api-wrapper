package dev.wilsonchiviti.starwarsapi.people.domain;

import dev.wilsonchiviti.starwarsapi.people.service.query.PeopleQueryService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
class PeopleQueryServiceImpl implements PeopleQueryService {

    private final PeopleRepository peopleRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Person> findAll(int page) {
        try {
            return peopleRepository.getPeople(page)
                    .results();
        } catch (FeignException ex) {
            return Collections.emptyList();
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Person findOne(String url) {
        return peopleRepository.getPerson(URI.create(url));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Person> searchPerson(String name, int page) {
        try {
            return peopleRepository.searchPerson(name, page)
                    .results();
        } catch (FeignException ex) {
            return Collections.emptyList();
        }
    }

}
