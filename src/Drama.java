import java.util.List;
import java.util.List;

public class Drama extends Movie implements AwardWinning {
    private List<String> mainCharacters;
    private String plotTwist;

    public Drama(String title, String director, int releaseYear, List<String> mainCharacters, String plotTwist) {
        super(title, director, releaseYear);
        setMainCharacters(mainCharacters);
        setPlotTwist(plotTwist);
    }

    public List<String> getMainCharacters() {
        return mainCharacters;
    }

    public void setMainCharacters(List<String> mainCharacters) {
        try {
            // Check if the input list is not null
            if (mainCharacters == null) {
                throw new IllegalArgumentException("Main characters list cannot be null.");
            }

            // Validate each element in the list
            for (String character : mainCharacters) {
                // Check if each element is a non-null string
                if (character == null || character.isEmpty()) {
                    throw new IllegalArgumentException("Main characters list cannot contain null or empty strings.");
                }

            }

            // If everything is fine, set the value
            this.mainCharacters = mainCharacters;
        } catch (IllegalArgumentException e) {
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }
    }

    public String getPlotTwist() {
        return plotTwist;
    }

    public void setPlotTwist(String plotTwist) {
        try {
            // Check if the input is a string
            if (plotTwist == null || !plotTwist.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$")) {
                throw new IllegalArgumentException("Plot twist must be a non-null string.");
            }

            // Check if the length is between 5 and 50 characters
            int length = plotTwist.length();
            if (length < 5 || length > 50) {
                throw new IllegalArgumentException("Plot twist must be between 5 and 30 characters.");
            }

            // If everything is fine, set the value
            this.plotTwist = plotTwist;
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
                "Best Picture, Best Director, and Best Actor awards!");
    }

    @Override
    public void thankSpeech() {
        System.out.println("Ladies and gentlemen, thank you for honoring our " + getTitle() + "." +
                " Grateful for the recognition and proud of our exceptional team's dedication to storytelling." +
                " Together, we've delved into the depths of human emotion, and this accolade is a testament to" +
                " the shared commitment that breathes life into our narrative. Thank you!");
    }

    @Override
    public void play() {
        System.out.println("Playing Drama: " + getTitle());
    }

    @Override
    public void stop() {
        System.out.println("Stopping Drama: " + getTitle());
    }

    public void depictEmotions() {
        System.out.println("Hey everyone, just wanted to share a glimpse into the emotional rollercoaster that is our " +
                "drama film. Each scene is a journey into the depths of the human experience – heartache, resilience," +
                " and the delicate dance between joy and sorrow.");
    }

    public void exploreConflictResolution() {
        System.out.println("Hey everyone, just reflecting on the powerful themes in our upcoming drama film. " +
                "It's a tale of redemption, forgiveness, and the arduous path to resolution.");
    }
}
