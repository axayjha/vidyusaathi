package com.vidyutsathi.models;

import java.util.List;
import java.io.Serializable;
import com.vidyutsathi.models.LocationCode;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class  DistrictMap implements Serializable {
    
    @Id
    @Getter @Setter String id;

    @Getter @Setter String distCode;

    @Getter @Setter String distName;

    @Getter @Setter List<LocationCode> locality;

    public DistrictMap(String distCode, String distName, List<LocationCode> locality) {
        this.distCode = distCode;
        this.distName = distName;
        this.locality = locality;
    }

    public DistrictMap(DistrictMap dm) {
        distCode = dm.distCode;
        distName = dm.distName;
        locality = dm.locality;
    }
    
}