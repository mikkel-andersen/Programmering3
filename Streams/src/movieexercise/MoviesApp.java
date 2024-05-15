package movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("movies.txt");
//        for (Movie m : movieList) {
//            System.out.println(m.getTitle());
//        }

        //movieList.stream().forEach(e -> System.out.println(e.getTitle()));
        System.out.println("Number of movies: " +movieList.size());

        //  The number of movies starting with "H"
        System.out.println("");
        System.out.println("Opgave 1");
        System.out.println("Number of movies that start with H");
        System.out.println("Movies that starts with 'H': " + movieList.stream().filter(e -> e.getTitle().startsWith("H")).count());

        // The title of the movies starting with "X"
        // TODO Opgave
        System.out.println("");
        System.out.println("Opgave 2");
        System.out.println("Movies that start with X");
        movieList.stream().filter(e -> e.getTitle().startsWith("X"))
                .map(Movie::getTitle)
                .forEach(System.out::println);

        // The number of films where the director is also an actor
        System.out.println("");
        System.out.println("Opgave 3");
        System.out.println("Number of films where the director is also an actor: ");
        long count = movieList.stream()
                .filter(e -> !Collections.disjoint(e.getActors(), e.getDirectors()))
                .count();
        System.out.println(count);

        //The number of actors in the film with the most actors

        System.out.println("");
        System.out.println("Opgave 4");
        int maxActors = movieList.stream()
                .mapToInt(e -> e.getActors().size())
                .max()
                .orElse(0);

        System.out.println("The number of actors in the film with the most actors: " + maxActors);

        // The title of the film with the most actors
        System.out.println("");
        System.out.println("Opgave 5");
        Movie movieWithMostActors = movieList.stream()
                .reduce((movie1, movie2) -> movie1.getActors().size() > movie2.getActors().size() ? movie1 : movie2)
                .orElse(null);

        if (movieWithMostActors != null) {
            System.out.println("The title of the film with the most actors: " + movieWithMostActors.getTitle());
        } else {
            System.out.println("No movies found");
        }

        //Number of films divided by first letter in the film title
        // TODO Opgave
        System.out.println("");
        System.out.println("Opgave 6");
        Map<Character, Long> moviesByFirstLetter = movieList.stream()
                .collect(Collectors.groupingBy(movie -> movie.getTitle().charAt(0), Collectors.counting()));

        moviesByFirstLetter.forEach((letter, count2) -> System.out.println("Letter: " + letter + ", Number of movies: " + count2));

        // Number of movies whose title starts with "The "
        System.out.println("");
        System.out.println("Opgave 7");
        System.out.println("Number of movies that start with 'The '");
        System.out.println("Movies that starts with 'The ': " + movieList.stream().filter(e -> e.getTitle().startsWith("The")).count());


//
    }


}

