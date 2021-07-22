package com.vidyutsathi.models;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document
@NoArgsConstructor
public class RegisteredDataviewer implements Serializable {

    @Id
    @Getter @Setter String id;

    @DBRef
    @Getter @Setter PowerOrganisation provider;

    @Getter @Setter String authorisationCode;

    @Email
    @Getter @Setter String email;

    @Getter @Setter String password;

    @Length(max=1)
    @Getter @Setter String type;

    public RegisteredDataviewer(PowerOrganisation provider, String authorisationCode, String email, String password, String type) {
        this.provider = provider;
        this.authorisationCode = authorisationCode;
        this.email = email;
        this.password = password;
        this.type = type;
    }
}