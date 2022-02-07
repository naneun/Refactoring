package cs09;

import cs09.app.Application;
import cs09.util.WaitingQueue;

public class Main {
    public static void main(String[] args) {
        Application cs09 = new Application(new WaitingQueue());
        cs09.run();
    }
}
