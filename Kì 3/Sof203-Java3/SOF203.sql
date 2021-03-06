Create database SOF203
go
use SOF203
go

create table USERS
(
	username nvarchar(50) not null,
	password nvarchar(50),
	role nvarchar(50),
	constraint PK_Users primary key(username)
)
go
create table STUDENTS
(
	Masv nvarchar(50) not null,
	Hoten nvarchar(50),
	Email nvarchar(50),
	SoDT nvarchar(15),
	GioiTinh bit,
	Diachi nvarchar(50),
	Hinh nvarchar(50),
	constraint PK_Students primary key(Masv)	
)
go
Create table GRADE
(
	ID int not null,
	MaSV nvarchar(50),
	TiengAnh int,
	Tinhoc int,
	GDTC int,
	constraint PK_GRADE primary key(ID),
	constraint FK_GRADE_STUDENTS foreign key(Masv) references Students(masv)
)
go

insert into USERS(username,password,role) values('HieuTT','123','GV')
insert into USERS(username,password,role) values('MaiDTT','123','GV')
insert into USERS(username,password,role) values('LoanTT','123','GV')
insert into USERS(username,password,role) values('AnhPTT','123','DT')
insert into USERS(username,password,role) values('HoaKTM','123','DT')
go

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00123',N'Lê Xuân Lý','LyLX@fpt.edu.vn','0912835824',1,N'Hà nội','LyLX.jpg')

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00124',N'Lê Xuân Liên','LienLX@fpt.edu.vn','0979835824',1,N'Hà nội','LienLX.jpg')

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00125',N'Trần Bình Minh','MinhTB@fpt.edu.vn','0979370970',1,N'Hà nội','MinhTB.jpg')

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00126',N'Lê Hương Lan','LanLH@fpt.edu.vn','0979370989',0,N'Hà Nam','LanLH.jpg')

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00127',N'Nguyễn Văn Linh','LinhNV@fpt.edu.vn','0979654789',1,N'Quảng Ninh','LinhNV.jpg')

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00128',N'Lê Minh Đăng','DangLM@fpt.edu.vn','0979234543',1,N'Bắc Giang','DangLM.jpg')

insert into STUDENTS(Masv,Hoten,Email,SoDT,GioiTinh,Diachi,Hinh) 
values('PH00129',N'Lê Thiện Trung','TrungLT@fpt.edu.vn','09129654789',1,N'Hà nội','TrungLT.jpg')
go

insert into GRADE(ID,MaSV,TiengAnh,Tinhoc,GDTC) values(1,'PH00123',9,5,8)
insert into GRADE(ID,MaSV,TiengAnh,Tinhoc,GDTC) values(2,'PH00124',8,7,6)
insert into GRADE(ID,MaSV,TiengAnh,Tinhoc,GDTC) values(3,'PH00125',10,5,9)
insert into GRADE(ID,MaSV,TiengAnh,Tinhoc,GDTC) values(4,'PH00127',7,10,6)
insert into GRADE(ID,MaSV,TiengAnh,Tinhoc,GDTC) values(5,'PH00129',8,3,7)
go

select * from GRADE
select * from STUDENTS
select * from USERS