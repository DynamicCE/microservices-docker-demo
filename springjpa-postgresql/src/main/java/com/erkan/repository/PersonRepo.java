package com.erkan.repository;

import com.erkan.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface PersonRepo extends JpaRepository<Person,Long> {
}
