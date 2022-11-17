package com.fintechapp.repository;

import com.fintechapp.model.entity.SignInDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignInDetailsRepository extends JpaRepository<SignInDetailsEntity,Long> {
}
