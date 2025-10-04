package org.rest.librarysytem.Repository;

import org.rest.librarysytem.Model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepo extends JpaRepository<Library,Integer>
{
    Optional<Object> findById(Long bookID);
}
