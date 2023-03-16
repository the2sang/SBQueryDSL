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

