package com.muratArslan.postgresqlrestapi.repository;

import com.muratArslan.postgresqlrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
