--liquibase formatted sql
--changeset konrad.niedzielski:3
CREATE TABLE user_data (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_login VARCHAR NOT NULL,
    user_password VARCHAR NOT NULL,
    CONSTRAINT uq_user_login UNIQUE (user_login)
);