drop table COURSE;
create table COURSE (id bigint auto_increment, code varchar(255), name varchar(255));

insert into COURSE (code, name) values('IT001','Intro to IT');
insert into COURSE (code, name) values('SC001','Intro to Science');