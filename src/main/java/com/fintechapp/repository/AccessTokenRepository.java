package com.fintechapp.repository;

import com.fintechapp.model.entity.AccessTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessTokenEntity,Long>{


}
