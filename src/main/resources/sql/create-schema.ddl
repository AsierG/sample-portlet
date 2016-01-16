
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

    create sequence hibernate_sequence;
