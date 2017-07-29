package com.damienrubio.skrib.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageDTO implements Serializable {

    private String body;

    private Long rayon;

}
