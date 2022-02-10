package cs10.response;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

public class HTTPResponse {
    private static final int STATUS_CONDE_LENGTH = 3;
    private static final String NEWLINE = "\n";
    private static final String DOUBLE_NEWLINE = "\n\n";

    private int statusCode;
    private String responseLine;
    private int contentLength;
    private Map<String, String> responseHeaders;
    private CharBuffer responseBody;

    public HTTPResponse(String responseLine, String responseBody) {
        String statusLine = responseLine.substring(0, responseLine.indexOf(NEWLINE));
        this.statusCode = getStatusCode(statusLine);
        this.responseLine = responseLine;
        this.responseHeaders = getResponseHeaders(responseLine.substring(responseLine.indexOf(NEWLINE) + 1));
        this.contentLength = Integer.parseInt(NVLContentLength(responseHeaders.get("Content-Length")));
        this.responseBody = CharBuffer.wrap(responseBody);
    }
    private int getStatusCode(String statusLine) {
        int statusCodeIndex = statusLine.indexOf(" ") + 1;
        return Integer.parseInt(statusLine.substring(statusCodeIndex, statusCodeIndex + STATUS_CONDE_LENGTH));
    }
    private Map<String, String> getResponseHeaders(String responseLine) {
        Map<String, String> responseHeaders = new HashMap<>();
        String[] headers = responseLine.split(NEWLINE);
        String delimiter = ": ";
        for (String header : headers) {
            int index = header.indexOf(delimiter);
            responseHeaders.put(header.substring(0, index), header.substring(index + delimiter.length()));
        }
        return responseHeaders;
    }
    private String NVLContentLength(String contentLength) {
        return contentLength == null ? "0" : contentLength.trim();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        responseHeaders.forEach((key, value) -> {
            sb.append(key).append(": ").append(value).append(NEWLINE);
        });
        return "[Custom HTTPResponse]" + NEWLINE +
                "+ (statusCode) = " + statusCode + DOUBLE_NEWLINE +
                "+ (responseLine)" + NEWLINE + responseLine + DOUBLE_NEWLINE +
                "+ (contentLength) = " + contentLength + DOUBLE_NEWLINE +
                "+ (HTTP Response header)" + NEWLINE + sb + DOUBLE_NEWLINE +
                "+ (HTTP Response Body - HTML)" + NEWLINE + responseBody + NEWLINE;
    }
}
