package cs10.constant;

public enum SPEC {
    HANI("www.hani.co.kr", "/"), DISNEY("www.disney.co.kr", "/home/index.jsp")
    , KHAN("www.khan.co.kr", "/"), YES24("www.yes24.com", "/")
    , KYOBOBOOK("www.kyobobook.co.kr", "/"), NAVER("m.naver.com", "/");

    private final String url;
    private final String path;

    SPEC(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public String getPath() {
        return path;
    }
}
