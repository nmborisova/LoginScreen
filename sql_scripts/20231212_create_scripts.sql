create database managementsystem;

create table users (
id int not null primary key auto_increment,
username varchar(20),
password varchar(20),
created timestamp,
is_active boolean
);