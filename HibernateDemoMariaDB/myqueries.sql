CREATE TABLE Persons (
    ID int NOT NULL AUTO_INCREMENT,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);

INSERT INTO Persons (FirstName,LastName, Age)
VALUES ('Lars','Monsen', 35);

INSERT INTO Persons (FirstName,LastName, Age)
VALUES ('Joe','Banana', 40);

INSERT INTO Persons (FirstName,LastName, Age)
VALUES ('Bugs','Bunny', 45);

