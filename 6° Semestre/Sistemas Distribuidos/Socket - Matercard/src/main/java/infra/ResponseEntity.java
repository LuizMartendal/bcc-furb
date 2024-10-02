package infra;

public class ResponseEntity<T> {
    private Integer statusCode;
    private T response;

    public ResponseEntity() {
    }

    public ResponseEntity(Integer statusCode, T response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
