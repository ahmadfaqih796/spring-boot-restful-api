CREATE TABLE contacts (
   id INT Auto_increment,
   username VARCHAR(100) NOT NULL,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100),
   phone VARCHAR(100),
   email VARCHAR(100),
   PRIMARY KEY (id),
   FOREIGN KEY fk_users_contacts (username) REFERENCES users(username)
);