create table car
(
    id    uuid not null
        constraint car_pk
            primary key,
    name  varchar(255),
    brand varchar(255)
);

alter table car
    owner to postgres;

create unique index car_id_uindex
    on car (id);

