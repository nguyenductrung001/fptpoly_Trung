create database QLSV1
go
use QLSV1
go

Create table KHOANGANH
(
	MaKN nvarchar(15) not null,
	TenKN nvarchar(50) not null,
	constraint PK_KhoaNganh primary key(MaKN)
)
go

create table SINHVIEN
(
	Masv nvarchar(10) not null,
	Hoten nvarchar(35) not null,
	MaKN nvarchar(15) not null,
	CMND nvarchar(16) ,
	DienThoai nvarchar(15),
	email nvarchar(45) not null,	
	constraint PK_SinhVien primary key(Masv),
	constraint FK_Sinhvien_Khoanganh foreign key(MaKn) references Khoanganh(MaKN)
)
go
--Nhập liệu bảng Khóa Ngành
insert into KhoaNganh(MaKN,TenKN) values('K12.3-MOB',N'K12.3 Ngành Mobile')
insert into KhoaNganh(MaKN,TenKN) values('K12.3-MUL',N'K12.3 Ngành Thiết kế đồ họa')
insert into KhoaNganh(MaKN,TenKN) values('K12.3-UD',N'K12.3 Ngành Ứng dụng phần mềm')
insert into KhoaNganh(MaKN,TenKN) values('K12.3-MA',N'K12.3 Ngành Marketing')
insert into KhoaNganh(MaKN,TenKN) values('K12.3-DIG',N'K12.3 Ngành Digital Marketing')
insert into KhoaNganh(MaKN,TenKN) values('K13.1-MOB',N'K13.1 Ngành Mobile')
insert into KhoaNganh(MaKN,TenKN) values('K13.1-MUL',N'K13.1 Ngành Thiết kế đồ họa')
insert into KhoaNganh(MaKN,TenKN) values('K13.1-UD',N'K13.1 Ngành Ứng dụng phần mềm')
insert into KhoaNganh(MaKN,TenKN) values('K13.1-MA',N'K13.1 Ngành Marketing')
insert into KhoaNganh(MaKN,TenKN) values('K13.1-DIG',N'K13.1 Ngành Digital Marketing')
go

--Nhập liệu bảng SinhVien
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email) 
values('PH00123',N'Lê Xuân Lý','K12.3-MOB','1213552671','0912825834','LyLX@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email) 
values('PH00125',N'Lê Xuân Liên','K12.3-MOB','01743552671','0912825866','LienLX@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email) 
values('PH00127',N'Lê ThuLan','K12.3-MOB','01743552677','0912825853','LanLT@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email)  
values('PH00131',N'Trần Thu Hà','K13.1-MUL','0174456879','079282866','HaTH@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email) 
values('PH00135',N'Nguyễn Minh Nghĩa','K13.1-MUL','0174456889','079282825','NghiaNM@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email)  
values('PH00137',N'Nguyễn Minh Trung','K13.1-MOB','0174456822','079282234','TrungNM@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email)  
values('PH00138',N'Trần Bình Minh','K13.1-UD','0174456234','078282825','MinhTB@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email)  
values('PH00234',N'Lê Hương Lan','K13.1-MA','0175734234','079265425','LanLH@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email) 
values('PH00235',N'Trần Thị Lương','K13.1-DIG','0174456255','078532825','LuongTT@fpt.edu.vn')
insert into SINHVIEN(Masv,Hoten,MaKN,CMND,DienThoai,email)  
values('PH00237',N'Đỗ Thị Mai','K13.1-DIG','0174456732','078222825','MaiDT@fpt.edu.vn')
go

select * from KHOANGANH
select * from SINHVIEN
