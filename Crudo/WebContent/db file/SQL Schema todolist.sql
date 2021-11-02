create user todolist identified by root;
grant connect, dba to todolist;
grant create session to todolist;

create sequence admin_id;
create table admin(
	id number(5) primary key not null, 
	firstname varchar2(20), 
	lastname varchar2(20), 
	email varchar2(50) unique, 
	username varchar2(30) unique, 
	password varchar(15), 
	role varchar2(5), 
	lastlogin TIMESTAMP,
	signupdate TIMESTAMP
);
insert into admin(id, firstname, lastname, email, username, password, role, lastlogin) values (admin_id.nextval, 'Samual', 'Singh', 'sam123@gmail.com', 'admin', 'root', 'admin', SYSDATE);

create sequence user_id;
create table users(
	id number(5) primary key not null,
	firstname varchar2(20), 
	lastname varchar2(20), 
	email varchar2(50) unique, 
	username varchar2(30) unique, 
	password varchar(15), 
	role varchar2(5),
	blocking varchar2(10),
	lastlogin TIMESTAMP,
	signupdate TIMESTAMP
);
insert into users(id, firstname, lastname, email, username, password, role, blocking, lastlogin, signupdate) values (user_id.nextval, 'Harsh', 'Pl', 'vicky542011@gmail.com', 'user', 'root', 'user', 'unblocked', SYSDATE, SYSDATE);

create sequence todo_id;
create table todolist (
	id number(8) primary key not null,
	userid number(5) references users(id),
	title varchar2(20),
	details varchar2(100),
	addedon TIMESTAMP,
	priority varchar2(30) check (priority in('high', 'low', 'mid')), 
	status varchar2(30) check (status in('pending', 'done', 'progress'))
);

insert into todolist (id, userid, title, details, addedon, priority, status) values(todo_id.nextval, 2, 'Home Work', 'Social since homework should be done on before 1/2/21', SYSDATE, 'mid', 'progress');