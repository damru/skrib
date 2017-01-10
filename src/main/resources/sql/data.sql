INSERT INTO users
  (lastname ,firstname ,username ,email ,age ,gender ,rayon ,latitude ,longitude,altitude)
VALUES
  ('Rubio', 'Damien', 'DRU', 'damien@skrib.me', 30, 'MALE', 5000, 0, 0, 0);


INSERT INTO messages
  (body ,latitude ,longitude ,altitude ,rayon ,date,author_id)
VALUES
  ('Hello world', 0, 0, 0, 1000, now(), 1);
