package com.vidyutsathi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vidyutsathi.models.PublicUser;

@Repository
public interface PublicUserRepository extends MongoRepository<PublicUser, String> {

        public PublicUser findByEmailAndPassword(String Email, String Password);

        public PublicUser findByEmail(String Email);
}
