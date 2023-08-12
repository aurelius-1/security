INSERT INTO users (ID, USERNAME, PASSWORD) VALUES (2, 'john', '123456');
INSERT INTO authorities (ID, NAME) VALUES (2, 'write');
INSERT INTO user_authorities (user_id, authority_id) VALUES (2, 2);