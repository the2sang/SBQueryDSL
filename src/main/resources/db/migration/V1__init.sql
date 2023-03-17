create table public.account
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

alter table public.account
    owner to postgres;

create table public.article
(
    id          bigint       not null
        primary key,
    author_id   bigint       not null,
    description varchar(200) not null,
    title       varchar(50) not null
);

alter table public.article
    owner to postgres;

create table public.author
(
    author_id integer not null
        primary key,
    email     varchar(50),
    name      varchar(50)
);

alter table public.author
    owner to postgres;

create table public.book
(
    book_id   integer not null
        primary key,
    isbn      varchar(20),
    name      varchar(100),
    author_id integer
        constraint fk_author
            references public.author
);

alter table public.book
    owner to postgres;

create table public.person
(
    id         bigint not null
        primary key,
    first_name varchar(20),
    last_name  varchar(20)
);

alter table public.person
    owner to postgres;

create table public.person_settings
(
    id        bigint not null
        primary key,
    person_id bigint
);

alter table public.person_settings
    owner to postgres;

create table public.team
(
    id   bigint not null
        primary key,
    name varchar(50)
);

alter table public.team
    owner to postgres;

create table public.member
(
    member_id bigint  not null
        primary key,
    age       integer not null,
    username  varchar(20),
    team_id   bigint
        constraint fk_team
            references public.team
);

alter table public.member
    owner to postgres;

--generate sequence
create sequence public.account_settings_seq
    increment by 50;

alter sequence public.account_settings_seq owner to postgres;

create sequence public.article_settings_seq
    increment by 50;

alter sequence public.article_settings_seq owner to postgres;

create sequence public.author_settings_seq
    increment by 50;

alter sequence public.author_settings_seq owner to postgres;

create sequence public.book_settings_seq
    increment by 50;

alter sequence public.book_settings_seq owner to postgres;

create sequence public.member_settings_seq
    increment by 50;

alter sequence public.member_settings_seq owner to postgres;

create sequence public.person_seq
    increment by 50;

alter sequence public.person_seq owner to postgres;

create sequence public.person_settings_seq
    increment by 50;

alter sequence public.person_settings_seq owner to postgres;

create sequence public.team_settings_seq
    increment by 50;

alter sequence public.team_settings_seq owner to postgres;
