package com.vidyutsathi.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class PublicCustomers implements Serializable{

    @Id
    @Getter @Setter String id;

    @DBRef
    @Getter @Setter PowerOrganisation provider;

    @Getter @Setter List<String> customerID;

    

    public PublicCustomers(PowerOrganisation provider, List<String> customerID) {
        this.provider = provider;
        this.customerID = customerID;
    }

    
}