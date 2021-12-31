use master
go
drop database QLPT1
go
create database QLPT1
go
--sử dụng csdl
use QLPT1
go

create table LN( 
  Maloainha  nvarchar(10)  not null,
  Tenloainha nvarchar(50) not null,
  constraint PK_loainha primary key (Maloainha),
)
go

create table QUAN
(
MaQuan nvarchar(10) not null,
TenQuan nvarchar(100) not null,
constraint PK_QUAN primary key (MaQuan),
)
go

create table NGUOIDUNG(
    MaNguoiDung nvarchar(10) not null,
    TenND nvarchar(30) not null,
	Gioitinh nvarchar(5) not null,
	SoDT nvarchar(20) not null,
	Diachi nvarchar(100) not null,
	MaQuan nvarchar(10) not null,
	Email nvarchar(100) not null,
	constraint PK_TenND primary key(MaNguoiDung),
) 
go
create table NHATRO(
	 Manhatro  nvarchar(10)  not null,
     Maloainha  nvarchar(10)  not null,
	 Dientich int not null,
	 Gia nvarchar(20) not null,
	 Diachi nvarchar(100) not null,
	 MaQuan nvarchar(10) not null,
	 mota nvarchar(500) not null,
	 ngaydang datetime not null,
	 NGUOIDUNG nvarchar(10) not null,
	 constraint PK_NHATRO primary key (Manhatro),
	 constraint FK_NHATRO_QUAN foreign key (MaQuan) references QUAN(MaQuan),
	 constraint FK_NHATRO_LN foreign key (Maloainha) references LN(Maloainha),
	 constraint FK_NHATRO_NGUOIDUNG foreign key (NGUOIDUNG) references NGUOIDUNG(MaNguoiDung),
)
go
 


create table NDNHATRO
(
	MaND nvarchar(10) not null,
	Manhatro  nvarchar(10)  not null,
	NgayDen datetime not null,
	NgayDi datetime not null,
	constraint PK_NDNHATRO primary key(MaND,Manhatro),
	constraint FK_NDNHATRO_NGUOIDUNG foreign key (MaND) references NGUOIDUNG(MaNguoiDung),
	constraint FK_NDNHATRO_NHATRO foreign key (Manhatro) references NHATRO(Manhatro),
)
go

create table DANHGIA(
   MaDanhGia nvarchar(10) not null,
   MaNguoiDung nvarchar(10) not null,
   Manhatro  nvarchar(10)  not null,
   TenND nvarchar(30) not null,
   NDDANHGIA nvarchar(500) not null,
   constraint PK_DANHGIA primary key(MaDanhGia),
   
   constraint FK_DANHGIA_NDNHATRO foreign key (MaNguoiDung,Manhatro) references NDNHATRO(MaND,Manhatro),
)
go