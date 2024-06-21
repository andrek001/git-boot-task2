package ru.netology.spring_boot_rest_task1.exception;

public class ApiError {
    String body;
    int statusCode;
    long timeStamp;

    public ApiError(String body, int statusCode, long timeStamp) {
        this.body = body;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
