--用户表
drop table ttt_user;
drop table ttt_emp;

create  table ttt_user(
	id varchar2(36) primary key,
	username varchar2(40),
	realName varchar2(40),
	password varchar2(40),
	sex varchar2(8),
	salt varchar2(16)
);
--测试数据
select * from ttt_user;
delete from ttt_user;


--员工表
create  table ttt_emp(
	id varchar2(36) primary key,
	name varchar2(40),
	salary number(12,2),
	age number(2),
	birthday date
);
select * from ttt_emp;