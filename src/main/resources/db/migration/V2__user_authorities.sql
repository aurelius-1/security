INSERT INTO users (ID, USERNAME, PASSWORD) VALUES (1, 'bill', '123456');
INSERT INTO authorities (ID, NAME) VALUES (1, 'read');
INSERT INTO user_authorities (user_id, authority_id) VALUES (1, 1);