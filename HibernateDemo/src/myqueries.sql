create table customers
(
    id int not null primary key
        generated always as identity
        (start with 1, increment by 1),
    name varchar(50)
);

insert into customers(name) values ('Large Comapny');
insert into customers(name) values ('Medium Comapny');
insert into customers(name) values ('Small Comapny');
