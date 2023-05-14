DROP TABLE IF EXISTS user_authorities;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;


CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45),
    password VARCHAR(45)
);

CREATE TABLE authorities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE user_authorities (
    user_id int,
    authority_id int,
    PRIMARY KEY (user_id, authority_id),
       CONSTRAINT `constr_userauth_user_fk`
       FOREIGN KEY `Users_fk` (`user_id`) REFERENCES `users` (`id`),
       CONSTRAINT `constr_userauth_authorities_fk`
       FOREIGN KEY `Authorities_fk` (`authority_id`) REFERENCES `authorities` (`id`)
);
