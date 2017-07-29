package com.damienrubio.skrib.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "idMessage")
public class Message extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long idMessage;

    private String body;

    private Position position;

    private Long rayon;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;

    /**
     * Distance is transient because we do not persist it as it depends on the user who is reading the message.
     */
    @Transient
    private double distance;

}
