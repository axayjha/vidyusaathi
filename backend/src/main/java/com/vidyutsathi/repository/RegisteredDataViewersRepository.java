package com.vidyutsathi.repository;

import com.vidyutsathi.models.RegisteredDataviewer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredDataViewersRepository extends MongoRepository<RegisteredDataviewer, String> {

        public RegisteredDataviewer findByEmailAndPassword(String email, String password);
}