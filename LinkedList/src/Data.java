import java.util.Arrays;

public class Data {
    public static final int MAX_COUNT = 5;
    public Video[] videos;

    public Data() {
        videos = new Video[MAX_COUNT];
        for (int idx = 0; idx < MAX_COUNT; ++idx) {
            videos[idx] = new Video((char) ('a' + idx) + "", "제목" + idx);
        }
    }

    public Video[] getVideos() {
        return videos;
    }

    @SuppressWarnings("unused")
    public void setVideos(Video[] videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Data{" +
                "videos=" + Arrays.toString(videos) +
                '}';
    }
}
