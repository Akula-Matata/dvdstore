package org.lightvanko.dvdstore.services;

import org.lightvanko.dvdstore.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}