package com.damienrubio.skrib.model;

import com.damienrubio.skrib.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users")
@Data
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

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long rayon;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Collection<Message> listeMessages;

    @Transient
    private Collection<Position> lieuxFavoris;

    private Position position;

}
