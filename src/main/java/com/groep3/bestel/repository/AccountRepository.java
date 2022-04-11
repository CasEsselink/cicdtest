package com.groep3.bestel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groep3.bestel.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
