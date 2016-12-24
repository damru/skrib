package com.damienrubio.skrib.models;

import com.damienrubio.skrib.enums.Sex;
import lombok.Data;

import java.util.Map;

@Data
public class User {
	private long id;
	private String nom;
	private String prenom;
	private String password;
	private String username;
	private String email;
	private int age;
	private Sex sex;
	private int rayon;
	private Map<Integer, Message> listeMessages;
	private Map<Integer, Position> lieuxFavoris;

}
