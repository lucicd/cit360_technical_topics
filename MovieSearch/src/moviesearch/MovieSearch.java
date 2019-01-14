/*
 * The MovieSearch class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package moviesearch;

import exceptions.ReadMoviesException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Drazen
 */
public class MovieSearch {

    /**
     * Builds an array list of genres from comma-separated-values input string
     *
     * @param genresStr
     * @return array list of genres
     */
    private static List<String> buildGenres(String genresStr) {
        List<String> genres;
        try (Scanner myScanner = new Scanner(genresStr).useDelimiter(",")) {
            genres = new ArrayList<>();
            while (myScanner.hasNext()) {
                String genre = myScanner.next();
                genres.add(genre);
            }
        }
        return genres;
    }

    /**
     * Builds a movie object based on the input line. Individual fields in the
     * line are separated by tabs.
     *
     * @param line
     * @return
     */
    private static Movie buildMovieObject(String line) {
        try (Scanner myScanner = new Scanner(line).useDelimiter("\t")) {
            Movie movie = new Movie();
            movie.setTconst(myScanner.next());
            movie.setTitleType(myScanner.next());
            movie.setPrimaryTitle(myScanner.next());
            movie.setOriginalTitle(myScanner.next());
            int isAdult = myScanner.nextInt();
            movie.setIsAdult(isAdult == 1);
            String startYear = myScanner.next();
            movie.setStartYear(startYear.equals("\\N") ? 0
                    : Integer.parseInt(startYear));
            String endYear = myScanner.next();
            movie.setEndYear(endYear.equals("\\N") ? 0
                    : Integer.parseInt(endYear));
            String runtimeMinutes = myScanner.next();
            movie.setRuntimeMinutes(runtimeMinutes.equals("\\N") ? 0
                    : Integer.parseInt(runtimeMinutes));
            String genres = myScanner.next();

            movie.setGenres(buildGenres(genres));
            return movie;
        }
    }

    /**
     * Reads the list of movies from the given input file
     *
     * @param fileName
     * @return the list of movies
     * @throws ReadMoviesException
     */
    private static List<Movie> readMovies(String fileName)
            throws ReadMoviesException {
        try (FileInputStream fips = new FileInputStream(fileName);
                Scanner input = new Scanner(fips)) {
            List<Movie> movies = new ArrayList<>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Movie movie = buildMovieObject(line);
                movies.add(movie);
            }
            return movies;
        } catch (Exception e) {
            System.err.println("\nThere was an error reading movies file. "
                    + e.getMessage());
            throw new ReadMoviesException("Cannot load movies file.");
        }
    }

    /**
     * Creates a set of keywords based on movie genres and names
     *
     * @param movie
     * @return set of keywords
     */
    private static Set<String> extractKeywords(Movie movie) {
        Set<String> keywords = new HashSet<>();

        //Use genres as keywords
        keywords.addAll(movie.getGenres());

        //Use movie names as keywords
        keywords.addAll(Arrays.asList(movie.getOriginalTitle().split(" ")));
        keywords.addAll(Arrays.asList(movie.getPrimaryTitle().split(" ")));
        return keywords;
    }

    private static Map<String, List<Movie>> buildKeywords(List<Movie> movies) {
        Map<String, List<Movie>> keywords = new TreeMap<>();
        for (Movie movie : movies) {
            Set<String> movieKeywords = extractKeywords(movie);
            for (String keyword : movieKeywords) {
                if (!keywords.containsKey(keyword)) {
                    keywords.put(keyword, new ArrayList<>());
                }
                List<Movie> existingMovies = keywords.get(keyword);
                existingMovies.add(movie);
            }
        }
        return keywords;
    }
    
    /**
     * Finds all movies whose names and genres contain given keyword
     * @param keywords
     * @param keyword
     * @return the list of found movies
     */
    private static List<Movie> findMovies(
            Map<String, List<Movie>> keywords, String keyword) {
        return keywords.get(keyword);
    }
    
    /**
     * Simple method to show movies on the screen.
     * @param movies 
     */
    private static void showMovies(List<Movie> movies) {
        movies.stream().forEach((Movie movie) -> {
            System.out.println(movie);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<Movie> movies = readMovies("movies.txt");
            Map<String, List<Movie>> keywords = buildKeywords(movies);
            List<Movie> foundMovies = findMovies(keywords, "Fireman");
            showMovies(foundMovies);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } 
    }

}
