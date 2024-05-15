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
        // TODO Opgave

        //The number of actors in the film with the most actors
        // TODO Opgave

        // The title of the film with the most actors
        // TODO Opgave

        //Number of films divided by first letter in the film title
        // TODO Opgave

        // Number of movies whose title starts with "The "
        // TODO Opgave


//
    }


}

