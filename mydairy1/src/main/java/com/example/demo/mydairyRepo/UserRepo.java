package com.example.demo.mydairyRepo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.mydairyEntites.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String username);
}
