CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE user_roles (
    user_id int,
    role_id int,
    PRIMARY KEY (user_id, role_id),
       CONSTRAINT `constr_userauth_user_role_fk`
       FOREIGN KEY `Users_fk` (`user_id`) REFERENCES `users` (`id`),
       CONSTRAINT `constr_userauth_roles_fk`
       FOREIGN KEY `Roles_fk` (`role_id`) REFERENCES `roles` (`id`)
);