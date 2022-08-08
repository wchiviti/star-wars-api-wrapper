package dev.wilsonchiviti.starwarsapi.people.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record Person(String url,
                     String name,
                     String height,
                     String mass,
                     String gender,
                     @JsonDeserialize(using = HomeworldDeserializer.class)
                     Homeworld homeworld) {
}
