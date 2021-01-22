-- 理发店数据库
create database Barbershop;
use Barbershop;

-- 会员表
create table Member(
	telephone VARCHAR(11) not null,
	name VARCHAR(20) not null,
	password VARCHAR(20) not null,
	balance DECIMAL unsigned set default 0,
	primary key (telephone)
);


-- 预约表
-- 主键选择 (时间&理发师) 因为理发师不能在同一时间服
-- 务不同客户而客户可以在同一时间预约多个理发师服务
create table Subscribe(
	subscribeTime VARCHAR(20) not null,
	memberId VARCHAR(11) not null,
	barberId VARCHAR(11) not null,
	project VARCHAR(11) not null,
	primary key(subscribeTime, barberId)
);


-- 记录表 记录系统中发生的事情 包括用户的注册 充值 消费 以及注销
create table Record(
	actionTime DATETIME not null,
	memberId VARCHAR(11) not null,
	amount DECIMAL not null,
    primary key(actionTime)
);


-- 管理员表
create table Administrator(
	telephone VARCHAR(11) not null,
	name VARCHAR(20) not null,
	password VARCHAR(20) not null,
	primary key (telephone)
);


-- 理发师表
create table Barber(
	telephone VARCHAR(11) not null,
	name VARCHAR(20) not null,
	password VARCHAR(20) not null,
	primary key (telephone)
);
