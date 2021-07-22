package com.vidyutsathi.repository;

import com.vidyutsathi.models.StateMap;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateMapRepository extends MongoRepository<StateMap, String> {
    StateMap findByStateCode(String code);
    
}