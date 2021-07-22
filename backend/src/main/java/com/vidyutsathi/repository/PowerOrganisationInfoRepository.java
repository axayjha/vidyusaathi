package com.vidyutsathi.repository;

import com.vidyutsathi.models.PowerOrganisationInfo;
import com.vidyutsathi.models.PowerOrganisation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerOrganisationInfoRepository extends MongoRepository<PowerOrganisationInfo, String> {

    public PowerOrganisationInfo findByProvider(PowerOrganisation pov);

}