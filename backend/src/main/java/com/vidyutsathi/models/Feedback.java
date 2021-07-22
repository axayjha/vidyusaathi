package com.vidyutsathi.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class Feedback implements Serializable{

    @Id
    @Getter @Setter String id;

    @DBRef
    @Getter @Setter PowerOrganisation provider;

    @Getter @Setter long timestampStart;

    @Getter @Setter long timestampEnd;

    public Feedback(PowerOrganisation provider, long timestampStart, long timestampEnd) {
        this.provider = provider;
        this.timestampStart = timestampStart;
        this.timestampEnd = timestampEnd;
    }

}