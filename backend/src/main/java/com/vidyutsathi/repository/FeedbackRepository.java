package com.vidyutsathi.repository;

import java.util.List;

import com.vidyutsathi.models.Feedback;
import com.vidyutsathi.models.PowerOrganisation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {

        public List<Feedback> findAllByProvider(PowerOrganisation po);

}