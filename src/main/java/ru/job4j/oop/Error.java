package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println("Active: " + active + ", " + "Status: " + status + ", " + "Message: " + message + ".");
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 120, "send");
        Error error3 = new Error(false, 56, "receive");
        error1.info();
        error2.info();
        error3.info();
    }
}
