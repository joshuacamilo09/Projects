package org.rest.librarysytem.Controller;

import org.rest.librarysytem.Model.User;
import org.rest.librarysytem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getNames()
    {
        return userService.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userService.save(user);
        return "User saved successfully";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user)
    {
        User update = userService.findById((long) id).get();
        update.setName(user.getName());
        update.setAge(user.getAge());
        update.setEmail(user.getEmail());

        userService.save(update);

        return "User updated successfully";
    }

    @DeleteMapping
    public String deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return "User " + id + " deleted successfully";
    }
}
