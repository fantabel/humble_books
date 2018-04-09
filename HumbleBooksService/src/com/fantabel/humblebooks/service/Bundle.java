package com.fantabel.humblebooks.service;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Bundle.findAll", query = "select o from Bundle o") })
public class Bundle implements Serializable {
    private static final long serialVersionUID = -4064183683501032783L;
    
    @Column(name = "BOUGHT_BY", length = 50)
    private String boughtBy;
    
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;
    
    @OneToMany(mappedBy = "bundle", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Book> bookList1;

    public Bundle() {
    }

    public Bundle(String boughtBy, BigDecimal id, String name, Date purchaseDate) {
        this.boughtBy = boughtBy;
        this.id = id;
        this.name = name;
        this.purchaseDate = purchaseDate;
    }


    public String getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(String boughtBy) {
        this.boughtBy = boughtBy;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @XmlTransient
    public List<Book> getBookList1() {
        return bookList1;
    }

    public void setBookList1(List<Book> bookList1) {
        this.bookList1 = bookList1;
    }

    public Book addBook(Book book) {
        getBookList1().add(book);
        book.setBundle(this);
        return book;
    }

    public Book removeBook(Book book) {
        getBookList1().remove(book);
        book.setBundle(null);
        return book;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("boughtBy=");
        buffer.append(getBoughtBy());
        buffer.append(',');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("name=");
        buffer.append(getName());
        buffer.append(',');
        buffer.append("purchaseDate=");
        buffer.append(getPurchaseDate());
        buffer.append(']');
        return buffer.toString();
    }
}
