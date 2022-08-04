package Homework4.Basic;

public class FlyException extends Exception {
    private final String msg;

    FlyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}