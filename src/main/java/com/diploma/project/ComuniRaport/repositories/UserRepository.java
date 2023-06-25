package com.diploma.project.ComuniRaport.repositories;

import com.diploma.project.ComuniRaport.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Modifying
    @Query("update User r set r.password = ?1 where r.email = ?2")
    void updatePassword(String password, String username);
}
