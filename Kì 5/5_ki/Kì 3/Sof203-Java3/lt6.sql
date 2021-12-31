create database lab6
go
use lab6
go
create table SinhVien
(
	masv nvarchar(7) not null primary key,
	hoten nvarchar(50) not null,
	tuoi int,
	nganh nvarchar(30)
)
go

insert into SinhVien values('PH00123',N'Lê Xuân Lý',29,'MOB')
insert into SinhVien values('PH00124',N'Lê Xuân Lâm',21,'MUL')
insert into SinhVien values('PH00120',N'Trần Thu Hà',26,'UD')
insert into SinhVien values('PH00127',N'Lê Xuân Lan',28,'UD')