package dev.wilsonchiviti.starwarsapi.utils;

import java.util.List;

public record Page<T>(int count,
                      String next,
                      String previous,
                      List<T> results) {
}
