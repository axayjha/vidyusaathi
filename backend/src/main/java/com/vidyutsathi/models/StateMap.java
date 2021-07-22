package com.vidyutsathi.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class StateMap implements Serializable {

    @Id
    @Getter @Setter String id;

    @Getter @Setter String stateCode;

    @Getter @Setter String stateName;

    @Getter @Setter List<DistrictMap> districtList;


    public StateMap(String stateCode, String stateName, List<DistrictMap> districtList) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.districtList = districtList;
    }

}