package dev.wilsonchiviti.starwarsapi.people.domain;

public record Person(String name,
                     String height,
                     String mass,
                     String gender,
                     String homeworld) {
}
