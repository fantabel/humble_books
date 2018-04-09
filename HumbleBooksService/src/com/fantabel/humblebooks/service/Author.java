package com.fantabel.humblebooks.service;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Author.findAll", query = "select o from Author o") })
public class Author implements Serializable {
    private static final long serialVersionUID = 2281578682573877405L;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy = "author", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Book> bookList;

    public Author() {
    }

    public Author(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book addBook(Book book) {
        getBookList().add(book);
        book.setAuthor(this);
        return book;
    }

    public Book removeBook(Book book) {
        getBookList().remove(book);
        book.setAuthor(null);
        return book;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("name=");
        buffer.append(getName());
        buffer.append(']');
        return buffer.toString();
    }
}
