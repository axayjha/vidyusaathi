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
public class PowerOrganisationInfo implements Serializable{

    @Id
    @Getter @Setter String id;

    @DBRef
    @Getter @Setter PowerOrganisation provider;

    @Getter @Setter BoundingBox serviceArea;

    @Getter @Setter String providerName;

    @Getter @Setter String address;

    @Getter @Setter List<PowerMeasurement> yearseries;

    @Getter @Setter List<PowerMeasurement> monthseries;
    
    @Getter @Setter List<PowerMeasurement> dayseries;


    public PowerOrganisationInfo(PowerOrganisation provider, BoundingBox serviceArea, String providerName, String address, List<PowerMeasurement> yearseries, List<PowerMeasurement> monthseries, List<PowerMeasurement> dayseries) {
        this.provider = provider;
        this.serviceArea = serviceArea;
        this.providerName = providerName;
        this.address = address;
        this.yearseries = yearseries;
        this.monthseries = monthseries;
        this.dayseries = dayseries;
    }
    

}