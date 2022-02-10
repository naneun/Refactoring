package cs10;

import cs10.application.Application;
import cs10.constant.SPEC;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args)
            throws MalformedURLException, UnknownHostException {

        Application application = new Application();
        application.run(SPEC.values()[4], "GET");
    }
}
