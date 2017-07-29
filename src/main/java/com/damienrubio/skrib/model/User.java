package com.damienrubio.skrib.model;

import com.damienrubio.skrib.model.converter.GenderConverter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idUser")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long idUser;

    private String lastname;

    private String firstname;

    /**
     * FIXME: maybe password will never be deserialized from RequestBody ?
     */
    private String password;

    private String username;

    private String email;

    private int age;

    @Convert( converter=GenderConverter.class )
    private Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Message> listeMessages;

    @JsonIgnore
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserSettings settings;

}
