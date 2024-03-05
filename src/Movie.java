import java.io.Serializable;

public abstract class Movie implements Serializable {
    protected String title;
    protected String director;
    protected int releaseYear;

    public Movie(String title, String director, int releaseYear){
        setTitle(title);
        setDirector(director);
        setReleaseYear(releaseYear);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        try {
            // Check if the input is a string
            if (title == null || !title.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$")) {
                throw new IllegalArgumentException("Title must be a non-null string.");
            }

            // Check if the length is between 5 and 30 characters
            int length = title.length();
            if (length < 1 || length > 20){
                throw new IllegalArgumentException("Title must be between 1 and 20 characters.");
            }
            // If everything is fine, set the value
            this.title = title;
        }
        catch (IllegalArgumentException e){
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        try {
            // Check if the input is a string
            if (director == null || !director.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$")){
                throw new IllegalArgumentException("Director's name must be a non-null string.");
            }

            // Check if the length is between 3 and 30 characters
            int length = director.length();
            if (length < 3 || length > 30){
                throw new IllegalArgumentException("Director's name must be between 3 and 30 characters.");
            }
            // If everything is fine, set the value
            this.director = director;
        }
        catch (IllegalArgumentException e){
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }
    }

    public void setReleaseYear(int releaseYear) {
        try {
            // Check if release year is a positive integer
            if (releaseYear < 0) {
                throw new IllegalArgumentException("Release year must be a positive number.");
            }
            // Check if release year is a valid movie year
            if (releaseYear < 1878) {
                throw new IllegalArgumentException("There were no movies before 1878.");
            }

            // If everything is fine, set the value
            this.releaseYear = releaseYear;
        }
        catch (IllegalArgumentException e){
            // Handle the exception or print the error message
            System.err.println("Exception caught: " + e.getMessage());
            // You may choose to rethrow if necessary
            // throw e;
        }

    }
    public int getReleaseYear(){
        return releaseYear;
    }

    public abstract void play();

    public abstract void stop();

}
