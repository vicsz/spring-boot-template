package com.sample.helloworld;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class SampleDatabaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique=true)
    @Pattern(regexp="([A-Za-z0-9])*", message="Must contain alpha-numeric characters only")
    private String salutation;

    @NotNull
    @Size(min=8, message="Must contain at least 8 characters")
    private String person;

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
