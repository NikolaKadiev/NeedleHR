package com.tandoori.needle.repository;

import com.tandoori.needle.service.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
    UserAccount findByEmail(String email);
}
