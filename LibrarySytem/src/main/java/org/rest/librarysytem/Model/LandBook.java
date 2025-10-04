package org.rest.librarysytem.Model;

import jakarta.persistence.*;
import org.rest.librarysytem.Service.LibraryService;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class LandBook
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne//Allow the connection of many land to one user
    private User user;

    @ManyToOne
    private Library books;

    private LocalDate LandDate;
    private LocalDate DevolutionDate;

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setBook(Library books)
    {
        this.books = books;
    }
    public  void setLandDate(LocalDate LandDate)
    {
        this.LandDate = LandDate;
    }

    public void setDevolutionDate(LocalDate localDate)
    {
        this.DevolutionDate = localDate;
    }
}
