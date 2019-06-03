package entity;

import annotation.Bean;
import annotation.Column;
import annotation.Id;

@Bean("book")
public class Book {
    @Id("book_id")
    private int book_id;
    @Column("book_name")
    private String book_name;
    @Column("book_price")
    private String book_price;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_price='" + book_price + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(int book_id, String book_name, String book_price) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
    }
}
