--liquibase formatted sql
--changeset kkuczynski:2
create table recipe (
    id bigint not null auto_increment PRIMARY KEY,
    num_rec int(2) unsigned not null,
    name_rec varchar(255) not null,
    type varchar(255) not null,
    created datetime not null,
    result_amount int(4) unsigned not null,
    result_extract double(3,1) not null,
    boil_time int(3) unsigned not null,
    time_whirpool int(3) unsigned not null
);
