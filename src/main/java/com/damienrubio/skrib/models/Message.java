package com.damienrubio.skrib.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Message {
	private long id;
	private String body;
	private User author;
	private ArrayList<Tag> tags;
	private Position position;
	private String distance;
	private Date date;

}
