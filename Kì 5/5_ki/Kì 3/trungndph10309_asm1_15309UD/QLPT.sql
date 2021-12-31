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
--Nhập liệu
--bảng1
insert into LN(Maloainha,Tenloainha)
values('LN01',N'Nha Tro'),
       ('LN02',N'Trung cư'),
	   ('LN03',N'Trung cư mini'),
	   ('LN04',N'Khách sạn'),
	   ('LN05',N'Nhà nghỉ')
go
--Bảng 2
insert into QUAN(MaQuan,TenQuan)
values ('Q01',N'Hoàn Kiếm'),
       ('Q02',N'Hai Bà Trưng'),
       ('Q03',N'Thanh Xuân'),
       ('Q04',N'Ba Đình'),
       ('Q05',N'Đống Đa')
go
--Bảng 3
insert into NGUOIDUNG(MaNguoiDung,TenND ,Gioitinh,SoDT ,Diachi,MaQuan,Email)
values ('ND001',N'Nguyen Van A',N'Nam',0987654321,N'Thanh Xuân','Q03',N'ANVPH0000@gmail.com'),
       ('ND002',N'Nguyen Van B',N'NỮ',0946444666,N'Hoàn Kiếm','Q01',N'BNVPH0000@gmail.com'),
       ('ND003',N'Nguyen Van C',N'NỮ',0987666555,N'Ba Đình','Q04',N'CNVPH0000@gmail.com'),
       ('ND004',N'Nguyen Van D',N'Nam',0322777888,N'Đống Đa','Q05',N'DNVPH0000@gmail.com'),
       ('ND005',N'Nguyen Van E',N'NỮ',0362999999,N'Hai Bà Trưng','Q02',N'ENVPH0000@gmail.com'),
       ('ND006',N'Nguyen Van F',N'Nam',0123456789,N'Thanh Xuân','Q03',N'FNVPH0000@gmail.com'),
       ('ND007',N'Nguyen Van G',N'Nam',0988999666,N'Đống Đa','Q05',N'GNVPH0000@gmail.com'),
       ('ND008',N'Nguyen Van H',N'NỮ',03222111111,N'Ba Đình','Q04',N'HNVPH0000@gmail.com'),
       ('ND009',N'Nguyen Van J',N'Nam',09999000999,N'Thanh Xuân','Q03',N'JNVPH0000@gmail.com'),
       ('ND010',N'Nguyen Van K',N'Nam',0987654321,N'Thanh Xuân','Q01',N'ANVPH0000@gmail.com')
	   go

-- bảng4
insert into NHATRO(Manhatro,Maloainha, Dientich,Gia,Diachi, MaQuan, mota, ngaydang, NGUOIDUNG)
values ('NT01','LN01',20,4000000,N'Hà Nội',N'Q01',N'Khép kín',2020/06/07,'ND001'),
		('NT02','LN02',30,4000000,N'Hà Nội',N'Q03',N'Không Khép kín',2020/07/07,'ND002'),
		('NT03','LN03',40,4000000,N'Hà Nội',N'Q05',N'Khép kín',2020/08/07,'ND003'),
		('NT04','LN04',50,4000000,N'Hà Nội',N'Q04',N'Khép kín',2020/09/07,'ND004'),
		('NT05','LN05',60,4000000,N'Hà Nội',N'Q02',N'Không Khép kín',2020/06/08,'ND005'),
		('NT06','LN04',70,4000000,N'Hà Nội',N'Q05',N'Khép kín',2020/06/07,'ND006'),
		('NT07','LN05',80,4000000,N'Hà Nội',N'Q01',N'Không Khép kín',2020/06/09,'ND007'),
		('NT08','LN02',60,4000000,N'Hà Nội',N'Q02',N' không Khép kín',2020/09/07,'ND008'),
		('NT09','LN02',50,4000000,N'Hà Nội',N'Q04',N'Khép kín',2020/05/07,'ND009'),
		('NT10','LN03',30,4000000,N'Hà Nội',N'Q01',N'Khép kín',2020/06/07,'ND001')
		go
--Bảng 5
insert into NDNHATRO(MaND,Manhatro,NgayDen,NgayDi)
values ('ND001','NT01',2020/02/04,2020/03/05),
       ('ND002','NT02',2020/02/03,2020/02/05),
	   ('ND006','NT03',2020/02/07,2020/02/14),
	   ('ND009','NT04',2020/02/04,2020/06/02),
	   ('ND007','NT05',2020/02/09,2020/02/18)
	   go

--bảng 6
insert into DANHGIA( MaDanhGia, MaNguoiDung, Manhatro,TenND,NDDANHGIA)
values ('DG01','ND001','NT01',N'Nguyen Van A',N'TỐT'),
		('DG02','ND002','NT02',N'Nguyen Van B',N'Kém'),
		('DG03','ND006','NT03',N'Nguyen Van G',N'Bình thường'),
		('DG04','ND009','NT04',N'Nguyen Van J',N'TỐT'),
		('DG05','ND007','NT05',N'Nguyen Van G',N'Kém')
go




























