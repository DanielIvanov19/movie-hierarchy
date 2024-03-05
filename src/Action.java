public class Action extends Movie implements D4Movie{


    public int getExplosions() {
        return explosions;
    }

    public void setExplosions(int explosions) {
        this.explosions = explosions;
    }

    private int explosions;
    public Action(String title, String director, int releaseYear, int explosions){
        super(title, director, releaseYear);
        setExplosions(explosions);
    }


    @Override
    public void play() {
        System.out.println("Playing Action movie: " + getTitle());
    }

    @Override
    public void stop() {
        System.out.println("Stopping Action movie: " + getTitle());
    }
}
