

-- Users

INSERT INTO Usuario (user_id, name, email, password, created, modified, last_login, token, is_active)
VALUES (1,'Eros','ermamone@gmail.com', 'password', null, null, null, null, 1);

INSERT INTO Usuario (user_id, name, email, password, created, modified, last_login, token, is_active)
VALUES (2,'Juan Rodriguez','juan@rodriguez.org', 'hunter2', null, null, null, null, 1);

-- Phone

INSERT INTO phones (phone_id, number, city_code, country_code, user_id)
VALUES (1, 56931465, 11, 54, 1);
INSERT INTO phones (phone_id, number, city_code, country_code, user_id)
VALUES (2, 55555555, 01, 55, 1);
INSERT INTO phones (phone_id, number, city_code, country_code, user_id)
VALUES (3, 1234567, 1, 57, 2);