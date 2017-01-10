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

CREATE TABLE user(
  id IDENTITY PRIMARY KEY,
  lastname varchar(62),
  firstname varchar(62),
  password VARCHAR(256),
  username VARCHAR(16),
  email VARCHAR(62),
  age INT,
  gender VARCHAR (12),
  rayon DOUBLE,
  latitude DOUBLE,
  longitude DOUBLE ,
  altitude DOUBLE
);

ALTER TABLE message
ADD FOREIGN KEY (author_id)
REFERENCES user(id) ;
