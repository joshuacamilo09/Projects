package org.rest.librarysytem.Service;

import org.rest.librarysytem.Model.User;
import org.rest.librarysytem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    public List<User> findAll()
    {
        return userRepo.findAll();
    }
    public Optional<User> findById(Long id)
    {
        return Optional.ofNullable(userRepo.findById(id).orElse(null));
    }
    public void deleteById(Long id)
    {
        userRepo.deleteById(id);
    }

    public void save(User user)
    {
        userRepo.save(user);
    }
}