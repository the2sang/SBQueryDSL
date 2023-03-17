-- drop table account;
-- drop table article;
-- drop table author;
-- drop table book;
-- drop table person;
-- drop table member;
-- drop table team;
--
-- drop sequence account_settings_seq;
-- drop sequence article_settings_seq;
-- drop sequence author_settings_seq;
-- drop sequence book_settings_seq;
-- drop sequence member_settings_seq;
-- drop sequence person_seq;
-- drop sequence team_settings_seq;

create table account
(
    id       bigint       not null
        primary key,
    email    varchar(50) not null
        constraint uk_account_email
            unique,
    password varchar(20) not null,
    roles    varchar(20) not null,
    username varchar(20) not null
        constraint uk_account_username
            unique
);

alter table account
    owner to postgres;

create table article
(
    id          bigint       not null
        primary key,
    author_id   bigint       not null,
    description varchar(200) not null,
    title       varchar(50) not null
);

alter table article
    owner to postgres;

create table author
(
    author_id integer not null
        primary key,
    email     varchar(50),
    name      varchar(50)
);

alter table author
    owner to postgres;

create table book
(
    book_id   integer not null
        primary key,
    isbn      varchar(20),
    name      varchar(100),
    author_id integer
        constraint fk_author
            references author
);

alter table book
    owner to postgres;

create table person
(
    id         bigint not null
        primary key,
    first_name varchar(20),
    last_name  varchar(20)
);

alter table person
    owner to postgres;

create table person_settings
(
    id        bigint not null
        primary key,
    person_id bigint
);

alter table person_settings
    owner to postgres;

create table team
(
    id   bigint not null
        primary key,
    name varchar(50)
);

alter table team
    owner to postgres;

create table member
(
    member_id bigint  not null
        primary key,
    age       integer not null,
    username  varchar(20),
    team_id   bigint
        constraint fk_team
            references team
);

alter table member
    owner to postgres;

--generate sequence
create sequence account_settings_seq
    increment by 50;

alter sequence account_settings_seq owner to postgres;

create sequence article_settings_seq
    increment by 50;

alter sequence article_settings_seq owner to postgres;

create sequence author_settings_seq
    increment by 50;

alter sequence author_settings_seq owner to postgres;

create sequence book_settings_seq
    increment by 50;

alter sequence book_settings_seq owner to postgres;

create sequence member_settings_seq
    increment by 50;

alter sequence member_settings_seq owner to postgres;

create sequence person_seq
    increment by 50;

alter sequence person_seq owner to postgres;

create sequence person_settings_seq
    increment by 50;

alter sequence person_settings_seq owner to postgres;

create sequence team_settings_seq
    increment by 50;

alter sequence team_settings_seq owner to postgres;
alter sequence team_settings_seq owner to postgres;