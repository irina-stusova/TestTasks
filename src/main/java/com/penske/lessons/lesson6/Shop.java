package com.penske.lessons.lesson6;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String shopName;
    private ArrayList<Book> booksList;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public Shop() {
    }

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public Shop(String shopName, ArrayList<Book> booksList) {
        this.shopName = shopName;
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return "Shop: " + this.shopName + ": " + this.booksList;
    }


    // метод для удаления одной книги (по критериям "Название" и "Автор");

    public ArrayList<Book> removeBook(String bookName, String bookAuthor) {
        ArrayList<Book> lOut = new ArrayList<>();
        for (Book book : booksList) {
            if (!book.getBookName().equals(bookName) && !book.getBookAuthor().equals(bookAuthor)) {
                lOut.add(book);
            }
        }
//        ArrayList<Book> lOut = (ArrayList<Book>) booksList.clone();
//        for (Book book : booksList) {
//            if (book.getBookName().equals(bookName) && book.getBookAuthor().equals(bookAuthor)) {
//                lOut.remove(book);
//            }
//        }
        return lOut;
    }


    // метод для добавления книги (сравнение по всем полям чтобы не было повторов,
    // при этом разрешается ввести несколько книг одного автора)

    public ArrayList<Book> addBook(String bookName, String bookAuthor, String publishingHouse, Long issueYear, Long pagesNumber, Double bookPrice, Book.CoverTypes coverType) {
        Book newBook = new Book(bookName, bookAuthor, publishingHouse, issueYear, pagesNumber, bookPrice, coverType);
        if (!booksList.contains(newBook)){
            booksList.add(newBook);
        }
//        ArrayList<Book> lOut = (ArrayList<Book>) booksList.clone();
//        for (Book book : booksList) {
//            if (!bookName.equals(book.getBookName()) && !issueYear.equals(book.getIssueYear()) && !pagesNumber.equals(book.getPagesNumber()) && !bookPrice.equals(book.getBookPrice())) {
//                lOut.add(new Book(bookName, bookAuthor, publishingHouse, issueYear, pagesNumber, bookPrice, coverType));
//                break;
//            }
//
//        }
        return booksList;
    }

    // метод для получения списка книг заданного автора

    public ArrayList<Book> getBooksOfAuthor(String bookAuthor) {
        ArrayList<Book> lOut = new ArrayList();
        for (Book book : booksList) {
            if (book.getBookAuthor().equals(bookAuthor)) {
                lOut.add(book);
            }
        }
        return lOut;
    }

// метод для получения списка книг, выпущенных в заданном интервале (включая границы)

    public ArrayList<Book> getBooksIssuedBetween(Long issueYearFrom, Long issueYearTo) {
        ArrayList<Book> lOut = new ArrayList();
        for (Book book : booksList) {
            if (book.getIssueYear() >= issueYearFrom && book.getIssueYear() <= issueYearTo) {
                lOut.add(book);
            }
        }
        return lOut;
    }

// метод для получения списка книг, выпущенных заданным издательством

    public ArrayList<Book> getBooksOfPublishingHouse(String publishingHouse) {
        ArrayList<Book> lOut = new ArrayList();
        for (Book book : booksList) {
            if (book.getPublishingHouse().equals(publishingHouse)) {
                lOut.add(book);
            }
        }
        return lOut;
    }


    public void printList(ArrayList<Book> list) {
        for (Book book : list) {
            System.out.println(book);
        }
    }
}

