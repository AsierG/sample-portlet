
    drop table CUSTOM_V2_PROJECT cascade constraints;

    drop table SAMPLE_COM_LOG_ACTION cascade constraints;

    drop table SAMPLE_SHOP cascade constraints;

    drop sequence SEQ_PROJECT;

    drop sequence SEQ_SAMPLE_ACTION;

    drop sequence SEQ_SHOP;

    create table CUSTOM_V2_PROJECT (
        project_id number(19,0) not null,
        company_id number(19,0),
        create_date timestamp,
        delivery_date timestamp,
        external number(1,0),
        group_id number(19,0),
        members number(10,0),
        modified_date timestamp,
        technologies varchar2(255 char),
        title varchar2(255 char),
        primary key (project_id)
    );

    create table SAMPLE_COM_LOG_ACTION (
        action_id number(19,0) not null,
        action_date timestamp not null,
        model varchar2(255 char) not null,
        parentEntity_class varchar2(255 char),
        parentEntity_id raw(255),
        resource_id number(19,0) not null,
        type varchar2(255 char) not null,
        user_id number(19,0) not null,
        primary key (action_id)
    );

    create table SAMPLE_SHOP (
        shop_id number(19,0) not null,
        active number(1,0) not null,
        creationDate timestamp,
        modifiedDate timestamp,
        userCreatorId number(19,0),
        userModifierId number(19,0),
        billing number(19,0),
        name varchar2(255 char),
        workers number(19,0),
        primary key (shop_id)
    );

    create sequence SEQ_PROJECT;

    create sequence SEQ_SAMPLE_ACTION;

    create sequence SEQ_SHOP;
