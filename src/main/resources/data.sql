use programming24summer;


INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (1, 'John', '1960-03-01', 'The Strip', 'Male');
INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (2, 'Jane', '2001-06-22', 'Tunnel Snakes', 'Female');
INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (3, 'Alice', '1990-05-15', 'The Legion', 'Female');
INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (4, 'Bob', '1985-11-30', 'The Kings', 'Male');
INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (5, 'Robin', '1975-01-01', 'The NCR', 'Male');
INSERT INTO athlete (id, name, birth_date, club, gender) VALUES (6, 'Eve', '1995-12-31', 'The NCR', 'Female');


INSERT INTO discipline (id, name, result_type) VALUES (1, '100 Meter Sprint', 'Time');
INSERT INTO discipline (id, name,result_type) VALUES (2, 'Pole Vault', 'Height');
INSERT INTO discipline (id, name, result_type) VALUES (3, '400 Meter Hedge', 'Time');
INSERT INTO discipline (id, name, result_type) VALUES (4, 'Spear Throwing', 'Distance');
INSERT INTO discipline (id, name, result_type) VALUES (5, 'Marathon', 'Time');
INSERT INTO discipline (id, name,result_type) VALUES (6, 'Long Jump', 'Distance');
INSERT INTO discipline (id, name, result_type) VALUES (7, 'Archery', 'Points');

INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (1, 'Time', '00:12:31', '2023-03-01', 1, 1);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (2, 'Height', '130', '2023-03-02', 2, 2);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (3, 'Time', '00:20:31', '2023-03-01', 2, 1);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (4, 'Time', '02:15:45', '2023-04-01', 3, 5);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (5, 'Distance', '150', '2023-04-02', 4, 6);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (6, 'Distance', '200', '2023-04-02', 4, 6);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (7, 'Distance', '250', '2023-04-02', 4, 6);
INSERT INTO result (id, result_type, result_value, date, athlete_id, discipline_id) VALUES (8, 'Points', '312', '2023-04-02', 4, 7);

INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (1, 1);
INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (2, 2);
INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (3, 5);
INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (4, 6);
INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (4, 7);
INSERT INTO athlete_disciplines (athlete_id, disciplines_id) VALUES (3, 4);
