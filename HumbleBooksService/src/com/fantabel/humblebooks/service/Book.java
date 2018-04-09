package com.fantabel.humblebooks.service;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Book.findAll", query = "select o from Book o") })
public class Book implements Serializable {
    private static final long serialVersionUID = -1438528019945563921L;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "BUNDLE_ID")
    private Bundle bundle;

    public Book() {
    }

    public Book(Author author, Bundle bundle, BigDecimal id, String name) {
        this.author = author;
        this.bundle = bundle;
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
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @XmlTransient
    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
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
