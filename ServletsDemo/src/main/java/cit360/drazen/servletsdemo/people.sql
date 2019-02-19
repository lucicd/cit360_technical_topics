CREATE DATABASE people;

CREATE TABLE people (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(1020) NOT NULL, 
    last_name VARCHAR(1020) NOT NULL, 
    birth_year INTEGER NOT NULL, 
    PRIMARY KEY (id)
);

INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('John', 'Glen', 1921);
INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('Alan', 'Shepard', 1923);
INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('Gus', 'Grissom', 1926);
INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('Gordon', 'Cooper', 1927);
INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('Wally', 'Schirra', 1923);
INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('Scott', 'Carpenter', 1925);
INSERT INTO people (first_name, last_name, birth_year) 
    VALUES ('Deke', 'Slayton', 1924);