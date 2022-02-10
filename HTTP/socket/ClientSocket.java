package cs10.socket;

import cs10.request.HTTPRequest;
import cs10.response.HTTPResponse;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private static final int READ_TIMEOUT = 3000;

    public static HTTPResponse sendAndReceive(HTTPRequest request, int port) {
        try (Socket socket = new Socket(request.getHost(), port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            socket.setSoTimeout(READ_TIMEOUT);
            out.write(request.convertToMessage());
            out.flush();

            return new HTTPResponse(readResponseLine(in), readResponseBody(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String readResponseLine(BufferedReader in) throws IOException {
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = in.readLine()) != null && !line.trim().equals("")) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }
    private static String readResponseBody(BufferedReader in) {
        StringBuffer sb = new StringBuffer();
        try {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {}
        return sb.toString();
    }
}
