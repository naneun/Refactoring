package cs10.header;

import java.util.Date;

public class HTTPCommonHeader {
    private Date date;
    private String connection;
    private int contentLength;
    private String contentType;
    private String contentLanguage;

    private HTTPCommonHeader(Builder builder) {
        this.date = builder.date;
        this.connection = builder.connection;
        this.contentLength = builder.contentLength;
        this.contentType = builder.contentType;
        this.contentLanguage = builder.contentLanguage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Date date = new Date();
        private String connection;
        private int contentLength; /* options, 'GET', 'DELETE' - 0, 'POST' - Content-Message-Length */
        private String contentType;
        private String contentLanguage;

        public Builder date(Date value) {
            date = value;
            return this;
        }

        public Builder connection(String connection) {
            this.connection = connection;
            return this;
        }

        public Builder contentLength(int contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder contentLanguage(String contentLanguage) {
            this.contentLanguage = contentLanguage;
            return this;
        }

        public HTTPCommonHeader build() {
            return new HTTPCommonHeader(this);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Date: ").append(date).append(System.lineSeparator())
                .append("Connection: ").append(connection).append(System.lineSeparator())
                .append("Content-length: ").append(contentLength).append(System.lineSeparator())
                .append("Content-type: ").append(contentType).append(System.lineSeparator())
                .append("Content-language: ").append(contentLanguage).append(System.lineSeparator());

        return sb.toString();
    }
}
