package com.vidyutsathi.models;

import java.io.Serializable;

import com.vidyutsathi.models.Coordinate;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@NoArgsConstructor
public class BoundingBox implements Serializable{


    @Getter
    @Setter public Coordinate upperLeft;

   
    @Getter
    @Setter public Coordinate lowerRight;

    
    public BoundingBox(Coordinate upperLeft, Coordinate lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }
    
}