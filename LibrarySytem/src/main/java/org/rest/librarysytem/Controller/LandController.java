package org.rest.librarysytem.Controller;

import org.rest.librarysytem.Model.LandBook;
import org.rest.librarysytem.Service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandController
{
    @Autowired
    private LandService landService;

    @PostMapping(value = "/makeLand")
    public LandBook realizeLand(@RequestParam Long userId, @RequestParam Long BookID)
    {
        System.out.println("Landed!");
        return landService.makeLand(userId, BookID);
    }
}
