package org.rest.librarysytem.Service;

import org.rest.librarysytem.Model.Library;
import org.rest.librarysytem.Repository.LandRepo;
import org.rest.librarysytem.Model.LandBook;
import org.rest.librarysytem.Model.User;
import org.rest.librarysytem.Repository.LibraryRepo;
import org.rest.librarysytem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.time.LocalDate;

@Service
public class LandService {

    @Autowired
    private LandRepo landRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LibraryRepo libraryRepo;

    private static final int BookLandLimit = 3;

    public LandBook makeLand (Long userId, Long bookID)
    {
        //verifying the existence of the book or the user
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found") );

        Library book = (Library) libraryRepo.findById(bookID)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        //verifying the book quantity

        int booklandQuant = landRepo.countbyuserid(userId);
        if (booklandQuant >= BookLandLimit)
        {
            throw new RuntimeException("Book limit reached");
        }

        LandBook land = new LandBook();
        land.setUser(user);
        land.setBook(book);
        land.setLandDate(LocalDate.now());
        land.setDevolutionDate(LocalDate.now().plusDays(7));

        user.setLandNum(booklandQuant + 1);

        return landRepo.save(land);
    }
}