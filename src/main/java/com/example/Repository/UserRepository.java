package com.example.Repository;

import com.example.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
        UserEntity findByPhone(String phone);
}
