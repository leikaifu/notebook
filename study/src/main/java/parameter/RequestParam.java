package parameter;

public class RequestParam {
    private Object method;
    private String url;
    private Object param;
    private Object check_template;

    public RequestParam(String url, Object param, RequestMethod method) {
        this.url = url;
        this.param = param;
        this.method = method;
    }



    public RequestParam(String url) {
        this(url, null, RequestMethod.GET);
    }

    public RequestParam() {

    }

    public Object getMethod() {
        return method;
    }

    public void setMethod(Object method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object getCheck_template() {
        return check_template;
    }
    public void setCheck_template(Object check_template) {
        this.check_template = check_template;
    }
}
