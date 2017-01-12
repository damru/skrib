package com.damienrubio.skrib.model;

import com.damienrubio.skrib.enums.DistanceUnit;
import com.damienrubio.skrib.enums.converter.DistanceUnitConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by damien on 12/01/2017.
 */
@Data
@Entity
@Table(name = "user_settings")
public class UserSettings {
    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private Long rayon;

    @Convert( converter=DistanceUnitConverter.class )
    private DistanceUnit distanceUnit;

}
