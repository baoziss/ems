select * from t_user
drop table t_user
select id,username,realname,password,salt from t_user
create table t_user(
	id varchar2(40) primary key,
	username varchar2(40),
	realname varchar2(40),
	password varchar2(40),
	sex varchar2(20),
	salt varchar2(40)
)
delete from t_user
commit
insert into t_user values (
			'1','wult',
			'wulongtao','123456',
			'man','1234'
)

select * from t_emp
select id,name,salary,age from t_emp
create table t_emp(
	id varchar2(40) primary key,
	name varchar2(40),
	salary number(10,2),
	age number(3)
)

