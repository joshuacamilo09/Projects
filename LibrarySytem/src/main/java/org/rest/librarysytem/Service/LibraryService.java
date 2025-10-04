package org.rest.librarysytem.Service;

import org.rest.librarysytem.Model.Library;
import org.rest.librarysytem.Repository.LibraryRepo;
import org.rest.librarysytem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService
{
    private LibraryRepo libraryRepo;

    @Autowired
    public LibraryService(LibraryRepo LibraryRepo)
    {
        this.libraryRepo = LibraryRepo;
    }

    public void saveAll(List<Library> books)
    {
        libraryRepo.saveAll(books);
    }
}