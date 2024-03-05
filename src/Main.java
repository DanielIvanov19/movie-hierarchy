import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static ArrayList<Movie> allMovies = new ArrayList<>();
    public static void main(String[] args) {
        readObjectsFromFile();
        Scanner sc = new Scanner(System.in);
        int command = 0;
        while (command!=5) {
            System.out.println("1. Add a movie to the database");
            System.out.println("2. Search a movie");
            System.out.println("3. Load movies from the database");
            System.out.println("4. Remove a movie");
            System.out.println("5. Exit");

            while (true) {
                System.out.println("Enter a command between 1 and 5: ");

                if (sc.hasNextInt()) {
                    command = sc.nextInt();
                    sc.nextLine();
                    if (command < 1 || command > 5){
                        System.out.println("The number you entered is not in the interval from 1 to 5. Please provide a valid number!");
                    }
                    else{
                        break;
                    }
                } else {
                    sc.nextLine();
                    System.out.println("You didn't input a valid integer. Try again.");
                }
            }
            switch (command) {
                case 1:
                    int smallCommand;
                    while (true) {
                        System.out.println("Choose a movie genre:");
                        System.out.println("1. Comedy");
                        System.out.println("2. Drama");
                        System.out.println("3. Sci-Fi");
                        System.out.println("4. Back to main menu");
                        smallCommand = sc.nextInt();
                        sc.nextLine();
                        switch (smallCommand) {
                            case 1:
                                addComedyMovie(sc);
                                break;
                            case 2:
                                addDramaMovie(sc);
                                break;
                            case 3:
                                addSciFiMovie(sc);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid genre choice Please enter a number between 1 and 3.");

                        }
                        System.out.println("Do you want to add another movie? (1. Yes / 2. No)");
                        int addAnother = sc.nextInt();
                        if (addAnother != 1) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true){
                        //sc.nextLine();
                        searchMovie(sc);

                        System.out.println("Do you want to search for another movie? (1. Yes / 2. No)");
                        int searchAnother = sc.nextInt();
                        if (searchAnother != 1) {
                            break;
                        }
                    }
                    break;
                case 3:
                    readObjectsFromFile();
                    break;
                case 4:
                    while (true){
                        removeMovieByTitle(sc);
                        System.out.println("Do you want to remove another movie? (1. Yes / 2. No)");
                        int removeAnother = sc.nextInt();
                        if (removeAnother != 1){
                            break;
                        }
                    }
                    break;
                case 5:
                    if (!allMovies.isEmpty()){
                        writeMoviesToFile();
                    }
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    break;
            }
        }

    }
    private static void addComedyMovie(Scanner sc) {
        System.out.println("Enter a comedy movie title:");

        String title = sc.nextLine();

        System.out.println("Enter the director's name:");
        String director = sc.nextLine();

        System.out.println("Enter the release year:");
        int releaseYear = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        System.out.println("Enter the humor type:");
        String humorType = sc.nextLine();

        System.out.println("Enter the number of funny scenes:");
        int funnyScenes = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        // Create a Comedy object with the provided information
        Comedy comedy = new Comedy(title, director, releaseYear, humorType, funnyScenes);

        // Add the Comedy object to the allMovies list
        allMovies.add(comedy);

        System.out.println("Comedy movie added to the database!");
    }

    private static void addDramaMovie(Scanner sc) {
        System.out.println("Enter a drama movie title:");
        String title = sc.nextLine();

        System.out.println("Enter the director's name:");
        String director = sc.nextLine();

        System.out.println("Enter the release year:");
        int releaseYear = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        System.out.println("Enter the main characters (comma-separated):");
        List<String> mainCharacters = new ArrayList<>(List.of(sc.nextLine().split(",\\s*")));

        System.out.println("Enter the plot twist:");
        String plotTwist = sc.nextLine();

        // Create a Drama object with the provided information
        Drama drama = new Drama(title, director, releaseYear, mainCharacters, plotTwist);

        // Add the Drama object to the allMovies list
        allMovies.add(drama);

        System.out.println("Drama movie added to the database!");
    }

    private static void addSciFiMovie(Scanner sc) {
        System.out.println("Enter a sci-fi movie title:");
        String title = sc.nextLine();

        System.out.println("Enter the director's name:");
        String director = sc.nextLine();

        System.out.println("Enter the release year:");
        int releaseYear = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        System.out.println("Enter futuristic technologies (comma-separated):");
        List<String> futuristicTechnology = new ArrayList<>(List.of(sc.nextLine().split(",\\s*")));

        System.out.println("Enter alien species (comma-separated):");
        List<String> alienSpecies = new ArrayList<>(List.of(sc.nextLine().split(",\\s*")));

        // Create a SciFiFilm object with the provided information
        SciFiFilm sciFiFilm = new SciFiFilm(title, director, releaseYear, futuristicTechnology, alienSpecies);

        // Add the SciFiFilm object to the allMovies list
        allMovies.add(sciFiFilm);

        System.out.println("Sci-Fi movie added to the database!");
    }

    private static void searchMovie(Scanner sc) {
        //sc.nextLine();
        System.out.println("Enter the title of the movie you want to search:");
        String searchTitle = sc.nextLine();

        boolean found = false;

        for (Movie movie : allMovies) {
            if (movie.getTitle().equalsIgnoreCase(searchTitle)) {
                // Display details of the found movie
                displayMovieDetails(movie);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Movie not found in the database.");
        }
    }

    private static void displayMovieDetails(Movie movie) {
        System.out.println("Movie Details:");
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Release Year: " + movie.getReleaseYear());

        if (movie instanceof Comedy) {
            Comedy comedy = (Comedy) movie;
            System.out.println("Humor Type: " + comedy.getHumorType());
            System.out.println("Funny Scenes: " + comedy.getFunnyScenes());
        } else if (movie instanceof Drama) {
            Drama drama = (Drama) movie;
            System.out.println("Main Characters: " + drama.getMainCharacters());
            System.out.println("Plot Twist: " + drama.getPlotTwist());
        } else if (movie instanceof SciFiFilm) {
            SciFiFilm sciFiFilm = (SciFiFilm) movie;
            System.out.println("Futuristic Technology: " + sciFiFilm.getFuturisticTechnology());
            System.out.println("Alien Species: " + sciFiFilm.getAlienSpecies());
        }

        System.out.println("---------------");
    }

    private static void removeMovieByTitle(Scanner sc) {
        System.out.println("Enter the title of the movie you want to remove:");
        String removeTitle = sc.nextLine();

        Movie movieToRemove = null;

        // Find the movie with the specified title
        for (Movie movie : allMovies) {
            if (movie.getTitle().equalsIgnoreCase(removeTitle)) {
                movieToRemove = movie;
                break;
            }
        }

        if (movieToRemove != null) {
            // Remove the movie from the list 
            allMovies.remove(movieToRemove);
            System.out.println("Movie removed successfully!");
        } else {
            System.out.println("Movie not found in the database. No removal performed.");
        }
    }

    private static void writeMoviesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movies.dat"))) {
            oos.writeObject(allMovies);
            System.out.println("Movies saved in the database successfully! Number of movies: " + allMovies.size());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing objects to file", e);
        }
    }

    @SuppressWarnings("unchecked")
    private static void readObjectsFromFile() {
        File file = new File("movies.dat");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                allMovies = (ArrayList<Movie>) ois.readObject();
                System.out.println("Movies loaded from the database successfully!");
            } catch (IOException | ClassNotFoundException e) {
                logger.log(Level.SEVERE, "Error reading objects from file", e);
            }
        } else {
            System.out.println("No current movies in the database");
        }
    }

}
