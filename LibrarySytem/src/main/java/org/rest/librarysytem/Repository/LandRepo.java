package org.rest.librarysytem.Repository;

import org.rest.librarysytem.Model.LandBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LandRepo extends JpaRepository<LandBook, Long>
{
    @Query("select count(e) from LandBook e where e.user.id = :userid")
    int countbyuserid(@Param("userid") Long userid);
}

