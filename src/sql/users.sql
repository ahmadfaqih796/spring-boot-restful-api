CREATE TABLE users (
   id INT Auto_increment,
   name VARCHAR(100) NOT NULL,
   username VARCHAR(100) NOT NULL,
   password VARCHAR(100) NOT NULL,
   token VARCHAR(100),
   token_expired_at BIGINT,
   PRIMARY KEY (id),
   UNIQUE (username),
   UNIQUE (token)
);
DROP TABLE users;
SELECT *
FROM `users`;
DESC `users`