package com.vidyutsathi.repository;

import com.vidyutsathi.models.PowerOrganisation;
import com.vidyutsathi.models.PublicCustomers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicCustomerRepository extends MongoRepository<PublicCustomers, String> {
        public boolean findByProviderAndCustomerID(PowerOrganisation provider, String customerID);
}