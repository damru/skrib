package com.damienrubio.skrib.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Data
@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String body;

    private Position position;

    private Long rayon;

    private Date date;

    @Transient
    private ArrayList<Tag> tags;

    /**
     * FIXME - Only Author id and username should be displayed
     */
    @JsonManagedReference("message-author")
    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;

    /**
     * Distance is transient because we do not persist it as it depends on the user who is reading the message.
     */
    @Transient
    private double distance;

}
