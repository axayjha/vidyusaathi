package com.vidyutsathi.models;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class PowerOrganisation implements Serializable {

    @Id
    @Getter @Setter String id;

    @Getter @Setter String stateCode;

    @Getter @Setter String distCode;

    @Getter @Setter String localCode;

    @Getter @Setter String organisationIdentifier;

    
    

    public PowerOrganisation(String stateCode, String distCode, String localCode, String organisationIdentifier) {
        this.stateCode = stateCode;
        this.distCode = distCode;
        this.localCode = localCode;
        this.organisationIdentifier = organisationIdentifier;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", stateCode='" + stateCode + "'" +
            ", distCode='" + distCode + "'" +
            ", localCode='" + localCode + "'" +
            ", organisationIdentifier='" + organisationIdentifier + "'" +
            "}";
    }

}