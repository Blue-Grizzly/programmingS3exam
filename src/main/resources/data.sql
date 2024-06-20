# use programming24summer;
#
#
# INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (1, 'John', '1960-03-01', 'Sierra Madres', 'Male');
# INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (2, 'Jane', '2001-06-22', 'Tunnel Snakes', 'Female');
#
#
# INSERT INTO discipline (id, name, result_type) VALUES (1, 'Running', 'Time');
# INSERT INTO discipline (id, name,result_type) VALUES (2, 'Jumping', 'Height');
#
# INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (1, 'Time', '01:20:31', '2023-03-01', 1, 1);
# INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (2, 'Type2', '130', '2023-03-02', 2, 2);
#
# INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (1, 1);
# INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (2, 2);