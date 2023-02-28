--liquibase formatted sql
--changeset kkuczynski:3
create table ingredient (
    id bigint not null auto_increment PRIMARY KEY,
    amount double(5, 2) not null,
    raw_id bigint not null,
    constraint fk_ingredient_raw_id foreign key (raw_id) references raw(id),
    recipe_id bigint not null,
    constraint fk_ingredient_recipe_id foreign key (recipe_id) references recipe(id)
);