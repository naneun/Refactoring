public class Main {
    public static void main(String[] args) {
        Editor<Video> editor = new Editor<>(new Data().getVideos());
        Util.print(editor);
        Util.run(editor);
    }
}
