import java.util.Objects;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class Video extends Node {
    public static final int MAX_PLAY_TIME = 15;

    private static Random random;
    private String title;
    private int playTime;

    public Video(String id, String title) {
        super(id);
        this.title = title;
        this.playTime = (getRandom().nextInt(MAX_PLAY_TIME) + 1);
    }

    private static Random getRandom() {
        if (Objects.isNull(random)) {
            random = new Random();
        }
        return random;
    }

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayTime() {
        return playTime;
    }

    @SuppressWarnings("unused")
    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return title + "(" + id + "):" + playTime;
    }
}
