package com.muratArslan.postgresqlrestapi.repository;

import com.muratArslan.postgresqlrestapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
