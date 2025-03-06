--liquibase formatted sql
--changeset konrad.niedzielski:1
CREATE TABLE People (
    person_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    age INT NOT NULL
)