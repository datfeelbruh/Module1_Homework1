package Homework4;

public class FlyException extends Exception {
    private final String msg;

    FlyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
