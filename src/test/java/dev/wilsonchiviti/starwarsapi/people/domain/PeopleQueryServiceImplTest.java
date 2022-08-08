package dev.wilsonchiviti.starwarsapi.people.domain;

import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@GraphQlTest
class PeopleQueryServiceImplTest {

    @MockBean
    private PeopleRepository peopleRepository;

}