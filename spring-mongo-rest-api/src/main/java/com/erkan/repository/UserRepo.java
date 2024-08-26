package com.erkan.repository;

import com.erkan.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public
interface UserRepo extends MongoRepository<User,String> {
}
