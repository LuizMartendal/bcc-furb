package infra;

public class Error extends RuntimeException {

    private Integer status;
    private String error;
    private String message;

    public Error(Integer status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
