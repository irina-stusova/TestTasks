package com.penske.lessons.lesson6;

import java.util.Objects;

public class Book {
    private String bookName;
    private String bookAuthor;
    private String publishingHouse;
    private Long issueYear;
    private Long pagesNumber;
    private Double bookPrice;
    public CoverTypes coverType;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Long getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(Long issueYear) {
        this.issueYear = issueYear;
    }

    public Long getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(Long pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public CoverTypes getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverTypes coverType) {
        this.coverType = coverType;
    }

    public enum CoverTypes {
        SOFT,
        HARD,
        CREATIVE
    };

    public Book(String bookName, String bookAuthor, String publishingHouse, Long issueYear, Long pagesNumber, Double bookPrice, CoverTypes coverType) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publishingHouse = publishingHouse;
        this.issueYear = issueYear;
        this.pagesNumber = pagesNumber;
        this.bookPrice = bookPrice;
        this.coverType = coverType;
    }
    @Override
    public String toString() {
        return "Book: '" + getBookName() + "', Author: " + getBookAuthor() + ", published by " + getPublishingHouse() + ", issued in: " + getIssueYear() + ", number of pages: " + getPagesNumber() + ", the price: " + getBookPrice() + ", the cover: " + getCoverType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookAuthor, book.bookAuthor) &&
                Objects.equals(publishingHouse, book.publishingHouse) &&
                Objects.equals(issueYear, book.issueYear) &&
                Objects.equals(pagesNumber, book.pagesNumber) &&
                Objects.equals(bookPrice, book.bookPrice) &&
                coverType == book.coverType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookAuthor, publishingHouse, issueYear, pagesNumber, bookPrice, coverType);
    }
}
