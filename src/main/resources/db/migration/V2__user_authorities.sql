INSERT INTO USERS (ID, USERNAME, PASSWORD) VALUES (1, 'bill', '123456');
INSERT INTO AUTHORITIES (ID, NAME) VALUES (1, 'read');
INSERT INTO USER_AUTHORITIES (user_id, authority_id) VALUES (1, 1);