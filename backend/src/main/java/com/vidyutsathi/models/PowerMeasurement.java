package com.vidyutsathi.models;

import java.io.Serializable;

import javax.validation.constraints.Email;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class PowerMeasurement implements Serializable{

    @Id
    @Getter @Setter String id;

    @Getter @Setter String timeseries;

    @Getter @Setter double units_consumed;

    @Getter @Setter double unit_price;

    public PowerMeasurement(String timeseries, double units_consumed, double unit_price){
        this.timeseries = timeseries;
        this.units_consumed = units_consumed;
        this.unit_price = unit_price;
    }

}