import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.List;

public class Comedy extends Movie implements AwardWinning {

    private String humorType;
    private int funnyScenes;

    public Comedy(String title, String director, int releaseYear, String humorType, int funnyScenes){
        super(title, director, releaseYear);
        setHumorType(humorType);
        setFunnyScenes(funnyScenes);
    }


    public String getHumorType(){
        return humorType;
    }

    public void setHumorType(String humorType){
        try {
            // Check if the input is a string
            if (humorType == null || !humorType.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$")) {
                throw new IllegalArgumentException("Humor type must be a non-null string.");
            }

            // Check if the length is between 3 and 15 characters
            int length = humorType.length();
            if (length < 3 || length > 15) {
                throw new IllegalArgumentException("Humor type must be between 3 and 15 characters.");
            }

            // If everything is fine, set the value
            this.humorType = humorType;
        } catch (IllegalArgumentException e) {
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }
    }

    public int getFunnyScenes(){
        return funnyScenes;
    }

    public void setFunnyScenes(int funnyScenes){
        try {
            // Check if the input is a positive integer
            if (funnyScenes < 0) {
                throw new IllegalArgumentException("Funny scenes must be a positive number.");
            }

            // If everything is fine, set the value
            this.funnyScenes = funnyScenes;
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
                "Comedy movie of the year, Best Editing, and Best Screenplay awards!");
    }

    @Override
    public void thankSpeech() {
        System.out.println("Ladies and gentlemen, honored guests, thank you for celebrating our" + getTitle() + "." +
                " Grateful for the laughs and proud of our incredible team's dedication to spreading joy." +
                " Together, we've crafted moments of hilarity, and this accolade is a testament to the collaborative" +
                " spirit that fuels our comedic journey. Thank you!");
    }

    @Override
    public void play() {
        System.out.println("Playing Comedy: " + getTitle());
    }

    @Override
    public void stop() {
        System.out.println("Stopping Comedy: " + getTitle());
    }

    public void deliverJokes(){
        System.out.println("You know, I did a great job playing the invisible man in my last film." +
                " It was so convincing that even the audience didn't notice me at the premiere!");
    }

    public void createLightheartedAtmosphere(){
        System.out.println("Hey folks! Just finished a day on set where I attempted to convince everyone I'm a serious" +
                ", Oscar-worthy actor. Spoiler alert: They're not buying it.");
    }


}
