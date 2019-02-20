CREATE DATABASE cit360;

CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL, 
    last_name VARCHAR(255) NOT NULL, 
    phone VARCHAR(255), 
    mobile VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL,
    street VARCHAR(255), 
    city VARCHAR(255), 
    state_code CHAR(2),
    zip_code INTEGER,
    PRIMARY KEY (id)
);

ALTER TABLE customers ADD UNIQUE (mobile);
ALTER TABLE customers ADD UNIQUE (email);

INSERT INTO cit360.customers (first_name, last_name, phone, mobile, email, street, city, `state_code`, zip_code) 
    VALUES ('Valerie', 'Smith', '609-359-6127', '479-477-1548', 'valerie@iffymedia.com', '3326  Lake Road', 'Dardanelle', 'AR', 72834);
INSERT INTO cit360.customers (first_name, last_name, phone, mobile, email, street, city, `state_code`, zip_code) 
    VALUES ('William', 'Pippin', '662-778-3058', '601-463-7979', 'william@thrubay.com', '798  Tanglewood Road', 'Moscow', 'MS', 38057);