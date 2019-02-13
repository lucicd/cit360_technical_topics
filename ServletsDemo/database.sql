CREATE DATABASE people;

CREATE TABLE people (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    birth_year int,
    PRIMARY KEY (id)
);