package com.damienrubio.skrib.model;

import com.damienrubio.skrib.enums.DistanceUnit;
import com.damienrubio.skrib.enums.Gender;
import com.damienrubio.skrib.enums.converter.DistanceUnitConverter;
import com.damienrubio.skrib.enums.converter.GenderConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String lastname;

    private String firstname;

    private String password;

    private String username;

    private String email;

    private int age;

    @Convert( converter=GenderConverter.class )
    private Gender gender;

    @JsonBackReference("message-author")
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Message> listeMessages;

    @Transient
    private Collection<Position> lieuxFavoris;

    private Position position;

    @OneToOne(mappedBy = "user")
    private UserSettings settings;

}
