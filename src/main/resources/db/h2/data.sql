INSERT INTO user
  (lastname ,firstname ,username ,email ,age ,gender)
VALUES
  ('Rubio', 'Damien', 'DRU', 'damien@skrib.me', 30, 'M')
  , ('Bohy', 'Fanny', 'FBO', 'damien@skrib.me', 30, 'F');

INSERT INTO user_settings
(rayon ,distance_unit, user_id)
VALUES
  (5000, 'M', 1)
  , (5000, 'KM', 2);

INSERT INTO message
  (body ,latitude ,longitude ,altitude ,rayon ,date,author_id)
VALUES
  ('Hello world', 48.810312, 2.362222, 80, 1000, now(), 2);
