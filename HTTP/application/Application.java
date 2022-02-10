package cs10.application;

import cs10.constant.SPEC;
import cs10.request.HTTPRequest;
import cs10.response.HTTPResponse;
import cs10.socket.ClientSocket;

import java.net.*;

public class Application {
    public void run(SPEC spec, String method) throws MalformedURLException, UnknownHostException {
        System.out.println("URL: http://" + spec.getUrl());
        System.out.println("(DNS Lookup...)");

        URL url = new URL("http://" + spec.getUrl() + spec.getPath());
        System.out.println("TCP Connection : " + InetAddress.getByName(spec.getUrl()).getHostAddress() + " " + url.getDefaultPort() + '\n');

        HTTPRequest request = new HTTPRequest(url, method);
        System.out.println("[HTTP Request]\n" + request.convertToMessage());

        HTTPResponse response = ClientSocket.sendAndReceive(request, url.getDefaultPort());
        System.out.println("[HTTP Response]\n" + response);
    }
}
