create database QLPT
go
--sử dụng csdl
use QLPT
go

create table LN(
  MaLoaiNha nvarchar(10) not null, 
  loainha  nvarchar(15)  not null,
  constraint PK_LN primary key (MaLoaiNha),
)
go
create table Quan(
	MaQuan nvarchar(10) not null,
	TenQuan nvarchar(20),
	constraint PK_Quan primary key (MaQuan),

	)
go
create table NGUOIDUNG(
	MaND nvarchar(10) not null,
    TenND nvarchar(30) not null,
	Gioitinh nvarchar(5) not null,
	SoDT nvarchar(10) not null,
	Diachi nvarchar(50) not null,
	MaQuan nvarchar(10) not null,
	Email nvarchar(50) not null,
	constraint PK_TenND primary key(MaND),
	constraint FK_NGUOIDUNG_QUAN foreign key (MaQuan) references Quan(MaQuan)
) 
go

create table NHATRO(
	 MaNhaTro nvarchar(10) not null,
	 MaLoaiNha nvarchar(10) not null, 
	 Dientich int not null,
	 Gia money,
	 Diachi nvarchar(50) not null,
	 MaQuan nvarchar(10) not null,
	 mota nvarchar(50) not null,
	 ngaydang datetime,
	 MaLienHe nvarchar(10) not null,
	 constraint PK_NHATRO primary key (MaNhaTro),
	 constraint FK_NHATRO_NGUOIDUNG foreign key (MaLienHe) references NGUOIDUNG(MaND),
	 constraint FK_NhaTro_Quan foreign key (MaQuan) references Quan(MaQuan),
	 constraint FK_NHATRO_LN foreign key (MaLoaiNha) references LN(MaLoaiNha)
)
go 

create table ND_NHATRO
(
	MaND nvarchar(10) not null,
	MaNhaTro nvarchar(10) not null,
	NgayDen datetime,
	NgayDi datetime,
	constraint PK_ND_NHATRO primary key (MAND,MANhaTro),
	constraint FK_ND_NHATRO_NGUOIDUNG foreign key (MaND) references NGUOIDUNG(MaND),
	constraint FK_ND_NHATRO_NHATRO foreign key (MaNhaTro) references NHATRO(MaNhaTro),
)
go
create table DANHGIA(
   MaDG nvarchar(10) not null,
   MaND nvarchar(10) not null,
   MaNhaTro nvarchar(10) not null, 
   Likes bit, 
   NDDANHGIA nvarchar(100) not null,
   constraint PK_DANHGIA primary key (MADG),
   constraint FK_DANHGIA_ND_NHATRO foreign key (MaND,MaNhaTro) references ND_NHATRO(MaND,MaNhaTro),
)
go

insert into LN(MaLoaiNha,loainha)
values ('LN01',N'Nhà Trọ'),
		('LN02',N'Chung cư')
go

insert into Quan(MaQuan,TenQuan)
values ('Q1',N'Hai Bà Trưng'),
		('Q2',N'Đống Đa'),
		('Q3',N'Thanh Xuân'),
		('Q4',N'Ba Đình')
go

insert into NGUOIDUNG(MaND,TenND,Gioitinh,SoDT,Diachi,MaQuan,Email)
values ('ND01',N'Trần Văn B',N'Nam',0987654321,N'Hà Nội','Q1','nhadaytien@gmail.com'),
		('ND02',N'Trần Thị C',N'Nữ',0987654221,N'Hà Nội','Q2','nhadayvang@gmail.com')
go

insert into NHATRO(MaNhaTro,MaLoaiNha,Dientich,Gia,Diachi,MaQuan,mota,ngaydang,MaLienHe)
values ('NT01','LN01',20,800000,N'Hà Nội',N'Q3',N'Không Khép kín',2020/06/07,'ND01'),
		('NT02','LN02',30,2700000,N'Hà Nội',N'Q4',N'Khép kín',2020/08/07,'ND02')
go

insert into ND_NHATRO(MaND,MaNhaTro,NgayDen,NgayDi)
values ('ND01','NT01',2020/01/04,2020/01/07),
		('ND02','NT02',2020/01/02,2020/01/07)
go

insert into DANHGIA(MaDG,MaND,MaNhaTro,Likes,NDDANHGIA)
values ('DG01','ND01','NT01',0,N'Tạm ổn'),
		('DG02','ND02','NT02',0,N'Tốt')

	