use master
go
if exists (select * from sysdatabases where name = 'QLDTIP') drop database QLDTIP
go
create database QLDTIP
go
use QLDTIP
go

create table CAMERA
(
	id int not null identity(1,1),
	resolution nvarchar(8) not null,

	constraint PK_CAMERA primary key (id)
)
create table OS
(
	id int not null identity(1,1),
	name nvarchar(25) not null,

	constraint PK_OS primary key (id)
)
create table SIM
(
	id int not null identity(1,1),
	sim_type nvarchar(30) not null,

	constraint PK_SIM primary key (id)
)
create table COLOUR
(
	id int not null identity(1,1),
	name nvarchar(18) not null,

	constraint PK_COLOUR primary key (id)
)
create table SCREEN
(
	id int not null identity(1,1),
	resolution nvarchar(30) not null,

	constraint PK_SCREEN primary key (id)
)
create table MEMORY
(
	id int not null identity(1,1),
	size int not null,
	unit nvarchar(3) not null,

	constraint PK_MEMORY primary key (id)
	)

create table PHONE
(
 id nvarchar(20) not null,
 name nvarchar(30) not null,
 amount int not null,
 sell_price money not null,
 details nvarchar(max),
 screen int not null,
 colour int not null,
 os int not null,
 front_cam int not null,
 behind_cam int not null,
 ram int not null,
 rom int not null,
 sim int not null,
 images int not null,
 phone_state bit not null,

 constraint PK_PHONE primary key (id),
 Constraint FK_PHONE_SCREEN foreign key (screen) references SCREEN(id),
 Constraint FK_PHONE_OS foreign key (os) references OS(id),
 Constraint FK_PHONE_SIM foreign key (sim) references SIM(id),
 Constraint FK_PHONE_CAMERA foreign key (behind_cam) references CAMERA(id),
 Constraint FK_PHONE_CAMERA1 foreign key (front_cam) references CAMERA(id),
 Constraint FK_PHONE_COLOUR foreign key (colour) references COLOUR(id),
 Constraint FK_PHONE_MEMORY foreign key (ram) references MEMORY(id),
 Constraint FK_PHONE_MEMORY1 foreign key (rom) references MEMORY(id),
)

create table PICS
(
	id int not null identity(1,1),
	phone_id nvarchar(20) not null,
	pic nvarchar(30) not null,
	
	constraint PK_PIC primary key (id),
	constraint FK_PICS_PHONE foreign key (phone_id) references PHONE(id)
)

create table INPUT_PHONE
(
	id int not null identity(1,1),
	phone_id nvarchar(20) not null,
	amount int not null,
	date_create datetime not null,
	in_or_out bit not null,
	buy_price money not null,

	constraint PK_INPUT_PHONE primary key (id),
	constraint FK_INPUT_PHONE_PHONE foreign key (phone_id) references PHONE(id)
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