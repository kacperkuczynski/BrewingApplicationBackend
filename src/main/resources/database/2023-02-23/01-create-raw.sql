--liquibase formatted sql
--changeset kkuczynski:1
create table raw (
    id bigint not null auto_increment PRIMARY KEY,
    type varchar(255) not null,
    name varchar(255) not null,
    unit_measure varchar(25) not null
);
