package org.rest.librarysytem.Repository;

import org.rest.librarysytem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}