create table oauth_client_details
(
    client_id               varchar(256) not null
        constraint oauth_client_details_pkey
            primary key,
    resource_ids            varchar(256),
    client_secret           varchar(256),
    scope                   varchar(256),
    authorized_grant_types  varchar(256),
    web_server_redirect_uri varchar(256),
    authorities             varchar,
    access_token_validity   integer,
    refresh_token_validity  integer,
    additional_information  varchar(4096),
    autoapprove             varchar(256)
);

create table oauth_client_token
(
    token_id          varchar(256),
    token             bytea,
    authentication_id varchar(256) not null
        constraint oauth_client_token_pkey
            primary key,
    user_name         varchar(256),
    client_id         varchar(256)
);

create table oauth_access_token
(
    token_id          varchar(256),
    token             bytea,
    authentication_id varchar(256) not null
        constraint oauth_access_token_pkey
            primary key,
    user_name         varchar(256),
    client_id         varchar(256),
    authentication    bytea,
    refresh_token     varchar(256)
);

create table oauth_refresh_token
(
    token_id       varchar(256),
    token          bytea,
    authentication bytea
);

create table oauth_code
(
    code           varchar(256),
    authentication bytea
);

create table oauth_approvals
(
    userid         varchar(256),
    clientid       varchar(256),
    scope          varchar(256),
    status         varchar(10),
    expiresat      timestamp,
    lastmodifiedat timestamp
);

create table permission
(
    id   serial not null
        constraint permission_pkey
            primary key,
    name varchar(512) default NULL::character varying
);

create table role
(
    id   serial not null
        constraint role_pkey
            primary key,
    name varchar(255) default NULL::character varying
);

create table users
(
    id               uuid    not null
        constraint user_pk
            primary key,
    first_name       varchar,
    middle_name      varchar,
    last_name        varchar,
    birthday         date,
    institution_name varchar,
    institution_code varchar not null,
    email            varchar not null,
    street           varchar,
    street_number    integer,
    city             varchar,
    postal_code      varchar,
    province         varchar,
    version          integer,
    role_id          integer not null
        constraint users_role_id_fk
            references role
);

create table account
(
    id                                   uuid not null
        constraint account_pk
            primary key,
    username                             varchar,
    password                             varchar,
    version                              integer,
    enabled                              boolean,
    account_non_expired                  boolean,
    credentials_non_expired              boolean,
    account_non_locked                   boolean,
    verification_token                   varchar,
    verification_token_expiration_date   timestamp,
    reset_password_token                 varchar,
    reset_password_token_expiration_date date,
    invite_token                         varchar,
    invite_token_expiration_date         timestamp
);

create table permission_role
(
    permission_id integer
        constraint permission_role_ibfk_1
            references permission,
    role_id       integer
        constraint permission_role_ibfk_2
            references role
);

create table databasechangeloglock
(
    id          integer not null
        constraint databasechangeloglock_pkey
            primary key,
    locked      boolean not null,
    lockgranted timestamp,
    lockedby    varchar(255)
);

create table databasechangelog
(
    id            varchar(255) not null,
    author        varchar(255) not null,
    filename      varchar(255) not null,
    dateexecuted  timestamp    not null,
    orderexecuted integer      not null,
    exectype      varchar(10)  not null,
    md5sum        varchar(35),
    description   varchar(255),
    comments      varchar(255),
    tag           varchar(255),
    liquibase     varchar(20),
    contexts      varchar(255),
    labels        varchar(255),
    deployment_id varchar(10)
);


