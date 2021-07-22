package com.vidyutsathi.repository;

import com.vidyutsathi.models.PowerOrganisation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerOrganisationRepository extends MongoRepository<PowerOrganisation, String> {
        PowerOrganisation findByStateCodeAndDistCodeAndLocalCodeAndOrganisationIdentifier(String sc, String dc, String lc, String org);
        PowerOrganisation findByStateCodeAndDistCodeAndLocalCode(String sc, String dc, String lc);
        PowerOrganisation findByStateCodeAndDistCode(String sc, String dc);
        PowerOrganisation findByStateCode(String sc);



}