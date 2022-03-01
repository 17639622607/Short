package mdao.entity;

public class Response {
    String url_short;
    String url_long;
    int type;

    public Response() {
    }

    public Response(String url_short, String url_long, int type) {
        this.url_short = url_short;
        this.url_long = url_long;
        this.type = type;
    }

    public String getUrl_short() {
        return url_short;
    }

    public void setUrl_short(String url_short) {
        this.url_short = url_short;
    }

    public String getUrl_long() {
        return url_long;
    }

    public void setUrl_long(String url_long) {
        this.url_long = url_long;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Response{" +
                "url_short='" + url_short + '\'' +
                ", url_long='" + url_long + '\'' +
                ", type=" + type +
                '}';
    }
}
