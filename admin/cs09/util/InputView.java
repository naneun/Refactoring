package cs09.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static InputView inputView;
    private BufferedReader br;

    private InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public void CLI() {
        System.out.print("> ");
    }

    public String readLine() throws IOException {
        return br.readLine();
    }
}
