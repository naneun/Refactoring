import java.util.Random;

public class Video extends Node {
    public static final int MAX_PLAY_TIME = 15;

    private String title;
    private int playTime;
    private static Random random;

    public Video(String id, String title) {
        super(id);
        this.title = title;
        this.playTime = (getRandom().nextInt(MAX_PLAY_TIME) + 1);
    }

    private static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return title + "(" + id + "):" + playTime;
    }
}
