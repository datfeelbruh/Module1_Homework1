package Homework4.Advanced2;

public class WatchBrokenError extends Exception {
    private final String msg;

    WatchBrokenError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
