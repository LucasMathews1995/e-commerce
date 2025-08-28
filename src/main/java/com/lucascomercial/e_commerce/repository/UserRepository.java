package com.lucascomercial.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascomercial.e_commerce.model.User;

public interface UserRepository extends JpaRepository<User,Long>{



}
