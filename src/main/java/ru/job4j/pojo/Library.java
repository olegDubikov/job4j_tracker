package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Алиса в Стране чудес", 150);
        Book book2 = new Book("Дон Кихот", 120);
        Book book3 = new Book("Java the best language", 1300);
        Book book4 = new Book("Clean code", 700);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book lib : books) {
            System.out.println("\"" + lib.getName() + "\"" + " кол-во страниц: " + lib.getPageCount());
        }
        System.out.println("");
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (Book lib : books) {
            System.out.println("\"" + lib.getName() + "\"" + " кол-во страниц: " + lib.getPageCount());
        }
        System.out.println("");
        for (Book lib : books) {
            if (lib.getName().equals("Clean code")) {
                System.out.println("\"" + lib.getName() + "\"" + " кол-во страниц: " + lib.getPageCount());
            }
        }
    }
}