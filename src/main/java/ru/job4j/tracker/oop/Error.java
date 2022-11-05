package ru.job4j.tracker.oop;

public class Error {

    private static boolean active;
    private static int status;
    private static String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error(true, 2, "Hello");
        error.printInfo();
    }

    public static void printInfo() {
        System.out.println("Активный: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }
}
