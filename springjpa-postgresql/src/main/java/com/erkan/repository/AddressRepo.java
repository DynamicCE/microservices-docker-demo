package com.erkan.repository;

import com.erkan.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface AddressRepo extends JpaRepository<Address,Long> {
}
