package cs10.header;

public class HTTPRequestHeader {
    private final HTTPCommonHeader commonHeader;
    private final String host;
    private final String origin;
    private String method;
    private String path;
    private String accept;

    private HTTPRequestHeader(Builder builder) {
        this.commonHeader = builder.commonHeader;
        this.host = builder.host;
        this.origin = builder.origin;
        this.method = builder.method;
        this.path = builder.path;
        this.accept = builder.accept;
    }

    public static Builder builder(HTTPCommonHeader commonHeader, String host, String origin) {
        return new Builder(commonHeader, host, origin);
    }

    public static class Builder {
        private final HTTPCommonHeader commonHeader;
        private final String host;
        private final String origin;
        private String method = "GET";
        private String path;
        private String accept = "*/*";

        public Builder(HTTPCommonHeader commonHeader, String host, String origin) {
            this.commonHeader = commonHeader;
            this.host = host;
            this.origin = origin;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder accept(String accept) {
            this.accept = accept.toUpperCase();
            return this;
        }

        public HTTPRequestHeader build() {
            return new HTTPRequestHeader(this);
        }
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(method + " " + path + " HTTP/1.1").append(System.lineSeparator())
                .append("Host: ").append(host).append(System.lineSeparator())
                .append("Origin: ").append(origin).append(System.lineSeparator())
                .append("Accept: ").append(accept).append(System.lineSeparator())
                .append(commonHeader.toString())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
