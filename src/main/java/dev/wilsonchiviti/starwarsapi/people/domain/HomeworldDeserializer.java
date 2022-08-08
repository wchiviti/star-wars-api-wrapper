package dev.wilsonchiviti.starwarsapi.people.domain;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
class HomeworldDeserializer extends JsonDeserializer<Homeworld> {

    @Override
    public Homeworld deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        val url = p.readValueAs(String.class);

        return new RestTemplate().getForObject(url, Homeworld.class);
    }
}
