package com.crypto.Assign5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crypto.Assign5.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByUsername(String username);
}
