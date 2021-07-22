package com.vidyutsathi.models;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class PublicUser implements Serializable{

    @Id
    @Getter @Setter String id;

    @Email
    @Getter @Setter String email;

    @Getter @Setter String password;

    @Getter @Setter PowerOrganisation provider;

    @Getter @Setter String customerID;

    @Getter @Setter List<PowerMeasurement> yearseries;

    @Getter @Setter List<PowerMeasurement> monthseries;
    
    @Getter @Setter List<PowerMeasurement> dayseries;

    public PublicUser(String email, String password, PowerOrganisation provider, String customerID, List<PowerMeasurement> yearseries, List<PowerMeasurement> monthseries, List<PowerMeasurement> dayseries) {
        this.email = email;
        this.password = password;
        this.provider = provider;
        this.customerID = customerID;
        this.yearseries = yearseries;
        this.monthseries = monthseries;
        this.dayseries = dayseries;
    }

}