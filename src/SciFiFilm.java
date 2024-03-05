import java.util.List;
import java.util.List;

public class SciFiFilm extends Movie implements AwardWinning{

    private List<String> futuristicTechnology;

    private List<String> alienSpecies;

    public List<String> getFuturisticTechnology(){
        return futuristicTechnology;
    }


    public SciFiFilm(String title, String director, int releaseYear, List<String> futuristicTechnology, List<String> alienSpecies){
        super(title, director, releaseYear);
        setFuturisticTechnology(futuristicTechnology);
        setAlienSpecies(alienSpecies);
    }

    public void setFuturisticTechnology(List<String> futuristicTechnology){
        try {
            // Check if the input list is not null
            if (futuristicTechnology == null) {
                throw new IllegalArgumentException("Futuristic technology list cannot be null.");
            }

            // Validate each element in the list
            for (String tech : futuristicTechnology) {
                // Check if each element is a non-null string
                if (tech == null || tech.isEmpty()) {
                    throw new IllegalArgumentException("Futuristic technology list cannot contain null or empty strings.");
                }

            }

            // If everything is fine, set the value
            this.futuristicTechnology = futuristicTechnology;
        } catch (IllegalArgumentException e) {
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }
    }

    public List<String> getAlienSpecies(){
        return alienSpecies;
    }

    public void setAlienSpecies(List<String> alienSpecies){
        try {
            // Check if the input list is not null
            if (alienSpecies == null) {
                throw new IllegalArgumentException("Alien species list cannot be null.");
            }

            // Validate each element in the list
            for (String alien : alienSpecies) {
                // Check if each element is a non-null string
                if (alien == null || alien.isEmpty()) {
                    throw new IllegalArgumentException("Alien species list cannot contain null or empty strings.");
                }

                // Add more validation rules if needed
            }

            // If everything is fine, set the value
            this.alienSpecies = alienSpecies;
        } catch (IllegalArgumentException e) {
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }
    }

    @Override
    public void displayAwards() {
        System.out.println("Thrilled to announce " + getTitle() + " is awarded for: " +
                "Science Fiction movie of the year, Best Sound Effects, and Best Visual Effects!");
    }

    @Override
    public void thankSpeech() {
        System.out.println("Ladies and gentlemen, thank you for honoring our " + getTitle() + ". Grateful for the recognition" +
                " and proud of our visionary team's dedication to exploring the unknown." +
                " Together, we've embarked on a journey beyond the stars, and this accolade is a testament" +
                " to the collective passion that fuels our cinematic voyage. Thank you!");
    }

    @Override
    public void play(){
        System.out.println("Playing Sci-Fi: " + getTitle());
    }

    @Override
    public void stop() {
        System.out.println("Stopping Sci-Fi: " + getTitle());
    }

    public void visualizeFutureWorld(){
        System.out.println("Hello, fellow explorers of the cinematic universe! Just concluded filming for our upcoming" +
                " sci-fi epic, and I must say, the vision of the future we've crafted is both mesmerizing" +
                " and thought-provoking. Picture a world where reality seamlessly intertwines with technology," +
                " where breathtaking landscapes are reshaped by human ingenuity, and mysteries unfold in the" +
                " depths of the cosmos.");
    }

    public void encounterAliens(){
        System.out.println("Amongst shadows, Earth encounters the cosmic unknown. A chilling dance ensues," +
                " unraveling horrors in the cosmic abyss.");
    }

}
