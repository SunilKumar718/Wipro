package assignments;

import java.util.ArrayList;
import java.util.List;

class Library<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> retrieveAll() {
        return items;
    }
}

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }

    public String toString() {
        return "Book: " + title;
    }
}

class Video {
    String title;

    Video(String title) {
        this.title = title;
    }

    public String toString() {
        return "Video: " + title;
    }
}

class Newspaper {
    String name;

    Newspaper(String name) {
        this.name = name;
    }

    public String toString() {
        return "Newspaper: " + name;
    }
}

public class Q39 {
    public static void main(String[] args) {
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.add(new Book("Java Basics"));
        bookLibrary.add(new Book("OOPs"));

        Library<Video> videoLibrary = new Library<>();
        videoLibrary.add(new Video("Java Tutorial"));
        
        Library<Newspaper> newsLibrary = new Library<>();
        newsLibrary.add(new Newspaper("The Times"));

        for (Book b : bookLibrary.retrieveAll()) {
            System.out.println(b);
        }

        for (Video v : videoLibrary.retrieveAll()) {
            System.out.println(v);
        }

        for (Newspaper n : newsLibrary.retrieveAll()) {
            System.out.println(n);
        }
    }
}

//Book: Java Basics
//Book: OOPs
//Video: Java Tutorial
//Newspaper: The Times

