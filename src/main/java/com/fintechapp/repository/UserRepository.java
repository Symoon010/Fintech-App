package com.fintechapp.repository;

import com.fintechapp.model.entity.SignUpDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<SignUpDetailsEntity,Long> {
    SignUpDetailsEntity findByUserName(String userName);
    Boolean existsByEmail(String userEmail);
//    Boolean existsByUsername(String userName);
//
//    Boolean existsByEmail(String userEmail);
}
