package com.dev.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BookMyShow.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long UserId);
	
	Optional<User> findByEmail(String email);
	
	User save(User user);

}
