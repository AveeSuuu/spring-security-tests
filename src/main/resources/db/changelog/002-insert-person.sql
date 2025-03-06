--liquibase formatted sql
--changeset konrad.niedzielski:2
insert into People(first_name, last_name, age)
values ('Jan', 'Kowalski', 23),
       ('Jerzy', 'Sapkowski', 76),
       ('Mateusz', 'Morawiecki', 32),
       ('Stanisław', 'Komorowski', 63),
       ('Konrad', 'Mazowiecki', 99)