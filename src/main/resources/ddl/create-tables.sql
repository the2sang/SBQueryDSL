create table public.account
(
    id       bigint       not null
        primary key,
    email    varchar(255) not null
        constraint uk_q0uja26qgu1atulenwup9rxyr
            unique,
    password varchar(255) not null,
    roles    varchar(255) not null,
    username varchar(255) not null
        constraint uk_gex1lmaqpg0ir5g1f5eftyaa1
            unique
);

alter table public.account
    owner to postgres;

create table public.article
(
    id          bigint       not null
        primary key,
    author_id   bigint       not null,
    description varchar(255) not null,
    title       varchar(255) not null
);

alter table public.article
    owner to postgres;

create table public.author
(
    author_id integer not null
        primary key,
    email     varchar(255),
    name      varchar(255)
);

alter table public.author
    owner to postgres;

create table public.book
(
    book_id   integer not null
        primary key,
    isbn      varchar(255),
    name      varchar(255),
    author_id integer
        constraint fkklnrv3weler2ftkweewlky958
            references public.author
);

alter table public.book
    owner to postgres;

create table public.person
(
    id         bigint not null
        primary key,
    first_name varchar(255),
    last_name  varchar(255)
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
    name varchar(255)
);

alter table public.team
    owner to postgres;

create table public.member
(
    member_id bigint  not null
        primary key,
    age       integer not null,
    username  varchar(255),
    team_id   bigint
        constraint fkcjte2jn9pvo9ud2hyfgwcja0k
            references public.team
);

alter table public.member
    owner to postgres;

