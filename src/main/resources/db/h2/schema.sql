CREATE TABLE user(
  id IDENTITY PRIMARY KEY,
  lastname varchar(62),
  firstname varchar(62),
  password VARCHAR(256),
  username VARCHAR(16),
  email VARCHAR(62),
  age INT,
  gender VARCHAR (3)
);

CREATE TABLE message(
  id IDENTITY PRIMARY KEY,
  body VARCHAR (200),
  latitude DOUBLE,
  longitude DOUBLE ,
  altitude DOUBLE ,
  rayon INT ,
  date DATE,
  author_id BIGINT
);

CREATE TABLE user_settings(
  id IDENTITY PRIMARY KEY,
  rayon DOUBLE,
  distance_unit VARCHAR(2),
  user_id BIGINT
);

ALTER TABLE message
  ADD FOREIGN KEY (author_id)
REFERENCES user(id) ;

ALTER TABLE user_settings
  ADD FOREIGN KEY (user_id)
REFERENCES user(id) ;
