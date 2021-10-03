package com.joaoluis.courseudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.courseudemy.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
