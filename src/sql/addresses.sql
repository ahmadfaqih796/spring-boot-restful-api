CREATE TABLE addresses (
   id INT Auto_increment NOT NULL,
   contact_id INT NOT NULL,
   street VARCHAR(200),
   city VARCHAR(100),
   province VARCHAR(100),
   country VARCHAR(100) NOT NULL,
   postal_code VARCHAR(10),
   PRIMARY KEY (id),
   FOREIGN KEY fk_contacts_addresses (contact_id) REFERENCES contacts (id)
);