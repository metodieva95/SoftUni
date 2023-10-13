package org.softuni.exam.structures;

import org.softuni.exam.entities.Actor;
import org.softuni.exam.entities.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieDatabaseImpl implements MovieDatabase {

    Map<String, Actor> actors = new LinkedHashMap<>();
    Map<String, Movie> movies = new LinkedHashMap<>();
    Map<String, List<Movie>> moviesByActors = new LinkedHashMap<>();
    Set<Actor> newbieActors = new LinkedHashSet<>();

    @Override
    public void addActor(Actor actor) {
        actors.put(actor.getId(), actor);
        moviesByActors.put(actor.getId(), new ArrayList<>());
        newbieActors.add(actor);
    }

    @Override
    public void addMovie(Actor actor, Movie movie) throws IllegalArgumentException {
        if (!contains(actor)) {
            throw new IllegalArgumentException();
        }

        movies.put(movie.getId(), movie);
        moviesByActors.get(actor.getId()).add(movie);
        newbieActors.remove(actor);
    }

    @Override
    public boolean contains(Actor actor) {
        return actors.containsValue(actor);
    }

    @Override
    public boolean contains(Movie movie) {
        return movies.containsValue(movie);
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return movies.values();
    }

    @Override
    public Iterable<Actor> getNewbieActors() {
        return newbieActors;
    }

    @Override
    public Iterable<Movie> getMoviesOrderedByBudgetThenByRating() {
        return movies.values().stream()
                .sorted(Comparator.comparing(Movie::getBudget).reversed()
                        .thenComparing(Movie::getRating).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Actor> getActorsOrderedByMaxMovieBudgetThenByMoviesCount() {
        return actors.values().stream()
                .sorted(Comparator.comparing(
                        (Actor a) -> moviesByActors.get(a.getId()).size()).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getMoviesInRangeOfBudget(double lower, double upper) {
        return movies.values().stream()
                .filter(m -> m.getBudget() >= lower && m.getBudget() <= upper)
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .collect(Collectors.toList());
    }
}
