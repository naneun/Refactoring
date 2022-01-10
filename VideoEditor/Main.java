import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor<Video> editor = new Editor<Video>(new Data().getDatas());

        /* LinkedList Version */
        System.out.println(editor);

        /* Collection Version */
        System.out.println("---영상클립---");
        for (Video video : editor.toCollection()) {
            System.out.println(video);
        }

        editor.itinerate();

        Scanner sc = new Scanner(System.in);
        String cmd;
        while ((cmd = sc.next()) != null) {
            if (cmd.equals("add")) {
                editor.add(new Video(sc.next(), "addItem"));
                editor.itinerate();
            } else if (cmd.equals("insert")) {
                editor.insert(new Video(sc.next(), "insertItem"), sc.nextInt());
                editor.itinerate();
            } else if (cmd.equals("delete")) {
                editor.delete(sc.next());
                editor.itinerate();
            } else if (cmd.equals("render")) {
                System.out.println(editor.render());
            } else if (cmd.equals("quit")) {
                System.out.println("bye~");
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
