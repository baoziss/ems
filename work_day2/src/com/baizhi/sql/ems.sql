--用户表
drop table t_user
create table t_user(
	id varchar2(36) primary key,
	username varchar2(40) unique not null,
	realname varchar2(40),
	password varchar2(40) not null,
	sex number(1) check(sex in('0','1')),
	salt varchar2(5)
)
insert into t_user values('1','wult','吴龙涛','123456',0,'123')

select * from t_user
delete from t_user
--部门表
drop table t_dept
create table t_dept(
	id varchar2(36) primary key,
	name varchar2(40) unique not null
)

insert into t_dept values('1','教学部')
insert into t_dept values('2','研发部')
commit
select * from t_dept
delete from t_dept
--员工表
drop table t_emp
create table t_emp(
	id varchar2(36) primary key,
	name varchar2(40) not null,
	salary number(10,2),
	age number,
	birthday date,
	dept_id references t_dept(id)
)
select * from t_emp
delete from t_emp

insert into t_emp values('1','ys',20000.0,23,to_date('1994-03-03','yyyy-mm-dd'),1)
insert into t_emp values('2','gyh',20000.0,22,to_date('1995-03-03','yyyy-mm-dd'),1)
commit

