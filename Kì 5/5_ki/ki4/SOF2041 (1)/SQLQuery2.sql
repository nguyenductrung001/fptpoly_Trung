use master
go
if exists (select * from sysdatabases where name = 'QLDTIP') drop database QLDTIP
go
create database QLDTIP
go
use QLDTIP
go


create table PHONE
(
 id nvarchar(20) not null,
 name nvarchar(30) not null,
 amount int not null,
 sell_price money not null,
 details nvarchar(max),
 cam nvarchar(50) not null,
 ram nvarchar(50) not null,
 rom nvarchar(50) not null,
 phone_state bit not null,

 constraint PK_PHONE primary key (id)
)

create table PICS
(
	id int not null identity(1,1),
	phone_id nvarchar(20) not null,
	pic nvarchar(30) not null,
	
	constraint PK_PIC primary key (id),
	constraint FK_PICS_PHONE foreign key (phone_id) references PHONE(id)
)

create table STOCK_RECEIPT
(
	id int not null identity(1,1),
	phone_id nvarchar(20) not null,
	amount int not null,
	date_create datetime not null,
	in_or_out bit not null,
	buy_price money not null,

	constraint PK_STOCK_RECEIPT primary key (id),
	constraint FK_STOCK_RECEIPT_PHONE foreign key (phone_id) references PHONE(id)
)

create table EMPLOYEE
(
	username nvarchar(30) not null,
	passwd nvarchar(32) not null,
	name nvarchar(40) not null,
	dateofbirth date not null,
	phone nvarchar(15) not null unique,
	email nvarchar(50) not null unique,
	pic nvarchar(40),
	salary money not null,
	addres nvarchar(100),
	position nvarchar(10) not null,

	constraint PK_EMPLOYEE primary key (username)
)

create table ORDERS
(
	id int not null identity(1,1),
	em_id nvarchar(30) not null,
	cus_name nvarchar(50) not null,
	cus_phone nvarchar(15) not null,
	date_create datetime not null,
	price money not null,

	constraint PK_ORDERS primary key (id),
	constraint FK_ORDERS_EMPLOYRR foreign key (em_id) references EMPLOYEE(username),
)

create table ORDER_DETAIL
(
	id int not null identity(1,1),
	phone_id nvarchar(20) not null,
	order_id int not null,
	amount int not null,

	constraint PK_ORDER_DETAIL primary key (id),
	constraint FK_ORDER_DETAIL_ORDER foreign key (order_id) references ORDERS(id),
	constraint FK_ORDER_DETAIL_PHONE foreign key (phone_id) references PHONE(id)
)

insert into employee(username,	passwd,	name,	dateofbirth,	phone,	email,	pic, salary,	addres,	position)
values('admin','admin',N'ma văn hùng', '1234-02-15','0385356782','hungmvph12447@fpt.edu.vn',null,1000000000,'','AD')