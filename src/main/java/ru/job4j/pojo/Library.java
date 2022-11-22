package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book detective = new Book("Detective", 368);
        Book novel = new Book("Novel", 532);
        Book fiction = new Book("Fiction", 241);
        Book cleancode = new Book("Clean code", 454);
        Book[] books = new Book[4];
        books[0] = detective;
        books[1] = novel;
        books[2] = fiction;
        books[3] = cleancode;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getName() + ": " + bo.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getName() + ": " + bo.getCount());
        }
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            if (bo.getName() == "Clean code") {
                System.out.println(bo.getName() + ": " + bo.getCount());
            }
        }
    }
}
