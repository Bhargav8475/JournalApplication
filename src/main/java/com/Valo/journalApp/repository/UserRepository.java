package com.Valo.journalApp.repository;

import com.Valo.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    public User findUserByUserName(String userName);

}
