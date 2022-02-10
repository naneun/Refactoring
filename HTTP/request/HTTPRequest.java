package cs10.request;

import cs10.header.HTTPCommonHeader;
import cs10.header.HTTPRequestHeader;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class HTTPRequest {
    private HTTPRequestHeader requestHeader;
    private String requestBody;

    public HTTPRequest(URL url, String method) throws UnknownHostException {
        String host = url.getHost();
        String origin = InetAddress.getLocalHost().getHostAddress();
        this.requestHeader = HTTPRequestHeader.builder(
                HTTPCommonHeader.builder()
                        .contentType("text/plain; charset=UTF-8")
                        .contentLanguage("en-US, ko-KR")
                        .build(), host, origin)

                .method(method).path(url.getPath()).build();

        this.requestBody = url.getQuery();
    }

    public String convertToMessage() {
        return requestHeader.toString();
    }

    public String getHost() {
        return requestHeader.getHost();
    }
}
