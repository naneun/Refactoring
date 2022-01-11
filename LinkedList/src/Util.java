import java.util.Objects;
import java.util.Scanner;

public class Util {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void print(Editor editor) {
        System.out.println(editor);

        System.out.println("---영상클립---");
        editor.toCollection().forEach(System.out::println);

        editor.travel();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void run(Editor editor) {
        Scanner sc = new Scanner(System.in);
        String cmd;
        while (Objects.nonNull(cmd = sc.next())) {
            switch (cmd) {
                case "add":
                    editor.add(new Video(sc.next(), "addItem"));
                    editor.travel();
                    break;
                case "insert":
                    editor.insert(new Video(sc.next(), "insertItem"), sc.nextInt());
                    editor.travel();
                    break;
                case "delete":
                    editor.delete(sc.next());
                    editor.travel();
                    break;
                case "render":
                    System.out.println(editor.render());
            }
        }
    }
}
