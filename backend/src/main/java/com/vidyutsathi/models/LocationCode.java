package com.vidyutsathi.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class LocationCode implements Serializable {

    @Id
    @Getter @Setter String id;

    @Getter @Setter String locationName;

    @Getter @Setter String locationCode;

    @Getter @Setter double landArea;

    @Getter @Setter double population; 

    @Getter @Setter BoundingBox boundingBox;

    public LocationCode(String locationName, String locationCode, double landArea, double population, BoundingBox boundingBox) {
        this.locationName = locationName;
        this.locationCode = locationCode;
        this.landArea = landArea;
        this.population = population;
        this.boundingBox = boundingBox;
    }
}