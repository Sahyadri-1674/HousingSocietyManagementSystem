create database housesystem;
use housesystem;
show tables;
create table visitor(dateinfo varchar(20),Flat_no varchar(20),Name varchar(50),timing varchar(20),mob_no varchar(20));
select *from visitor;
select * from info1;
select * from complaint_box;
use housesystem;
create table login_info(username varchar(50),password_info varchar(20));


select *from Vehicle_details;


#notice.java(some error)
create table notice(title varchar(20),category varchar(20),issued_date varchar(20),sender varchar(20),descript varchar(50));
select * from notice;

#loginpage.java
create table login_inform(username varchar(50),password_info varchar(20));
select *from login_inform;

create table Vehicle_details(Flat_no varchar(50),Parking_no varchar(50),Vehicle_no varchar(50),Owner_name varchar(50),Vehicle_Type varchar(50));


#maintenance.java
create table maintenance(month_info varchar(20),membername varchar(50),amount varchar(50),room int,pay_status varchar(10));
drop table maintenance; 
create table maintenance(month_info varchar(20),room varchar(50),amount varchar(50),membername varchar(50),area varchar(50),pay_status varchar(10));
select *from maintenance;

#complaintbox.java(syntax error in pgm)
create table complaint_box(flat_no int ,subj varchar(100) not null,descript varchar(1000) not null);
Drop table complaint_box;
Alter table complaint_box 
Add primary key (flat_no);
Alter table complaint_box 
Drop  primary key;
select * from complaint_box;


create table info1(Fname varchar(20),Lname varchar(20),Email varchar(40),Mob varchar(20),date1 varchar(20),month1 varchar(20),year1 varchar(20),adhaar varchar(50),room varchar(20),floor varchar(20),occup varchar(20),wing varchar(20),nom varchar(20),flat varchar(20));
drop table info1;

