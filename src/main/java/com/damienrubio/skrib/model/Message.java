package com.damienrubio.skrib.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private User author;

    @Transient
    private ArrayList<Tag> tags;

    private Position position;

    private Long rayon;

    private Date date;

}
