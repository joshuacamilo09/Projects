package org.rest.librarysytem.Model;

import jakarta.persistence.*;

@Entity
public class Library
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int isbn;

    @Column
    private String BookName;

    @Column
    private String BookAuthor;

    public Library(Long id, int isbn, String BookName, String BookAuthor)
    {
        this.id = id;
        this.isbn = isbn;
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
    }

    public Library() {

    }
}
