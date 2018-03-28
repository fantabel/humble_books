set define off;
drop table book;
drop table author;
drop table bundle;

drop sequence book_seq;
drop sequence author_seq;
drop sequence bundle_seq;

create table book (
    id number not null,
    name varchar2(50) not null,
    author_id number,
    bundle_id number not null
);

create table author (
    id number not null,
    name varchar2(50) not null
);

create table bundle (
    id number not null,
    name varchar2(100) not null,
    purchase_date date,
    bought_by varchar2(50)
);
    

alter table book add constraint book_pk primary key (id);
alter table author add constraint author_pk primary key (id);
alter table bundle add constraint bundle_pk primary key (id);

alter table book add constraint book_name_uk unique (name);

alter table book add constraint book_author_fk foreign key (author_id) references author(id);
alter table book add constraint book_bundle_fk foreign key (bundle_id) references bundle(id);

create index book_author_fk_i on book(author_id);
create index book_bundle_fk_i on book(bundle_id);

create sequence book_seq;
create sequence author_seq;
create sequence bundle_seq;

create or replace trigger bundle_bi_seq before insert on bundle for each row when (new.id is null)
declare
    v_id bundle.id%type;
begin
    select bundle_seq.nextval into v_id from dual;
    
    :new.id := v_id;
end bundle_bi_seq;

