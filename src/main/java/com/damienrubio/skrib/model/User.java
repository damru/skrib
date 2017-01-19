package com.damienrubio.skrib.model;

import com.damienrubio.skrib.enums.Gender;
import com.damienrubio.skrib.enums.converter.GenderConverter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String lastname;

    private String firstname;

    /**
     * FIXME: maybe password will never be deserialized from RequestBody ?
     */
    @JsonIgnore
    private String password;

    private String username;

    private String email;

    private int age;

    @Convert( converter=GenderConverter.class )
    private Gender gender;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Message> listeMessages;

    @Transient
    private Collection<Position> lieuxFavoris;

    /**
     * We do not save the user's position.
     * It should be send everytime by the frontend application.
     */
    @Transient
    private Position position;

    /**
     * We want to load settings only when explicitly needed.
     */
//    @Transient
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserSettings settings;

}
