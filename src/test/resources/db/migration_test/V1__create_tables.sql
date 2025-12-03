

create table category (
    id bigserial primary key,
    name varchar
);

create table country (
    id bigserial primary key,
    name varchar,
    code varchar
);

create table item (
    id bigserial primary key,
    name varchar,
    price int,
    country_id bigint references country(id) on delete cascade
);

create table item_categories (
    item_id bigint not null references item(id) on delete cascade,
    categories_id bigint not null references category(id) on delete cascade
);


