create database Quanlybanhang
go
use quanlybanhang
go
create table KhachHang
(

MaKH nvarchar(5) not null,
HovaTenLot nvarchar(20) not null,
Ten nvarchar(10) not null,
DiaChi nvarchar(40) not null,
Email nvarchar(40) not null,
DienThoai nvarchar(15) not null,
constraint PK_KhachHang primary key(MaKH)
)
go
create table HoaDon
(
MaHoaDon nvarchar(5) not null,
NgayMuaHang datetime,
MaKH nvarchar(5) not null,
TrangThai nvarchar(20) not null,
constraint PK_HoaDon primary key (MaHoaDon),
constraint FK_HoaDon_KhachHang foreign key (MaKH) references KhachHang (MaKH),
)
create table SanPham
(
MaSanPham nvarchar(5) not null,
MoTa nvarchar(5) not null,
SoLuong nvarchar(5) not null,
DonGia nvarchar(5) not null,
TenSp nvarchar(30) not null,
constraint PK_SanPham primary key (MaSanPham),
)
create table HoaDonChiTiet
(
MaHoaDon nvarchar(5) not null,
MaSanPham nvarchar(5) not null,
SoLuong nvarchar(20) not null,
MaHoaDonChiTiet nvarchar(5) not null,
constraint FK_HoaDonChiTiet_HoaDon foreign key (MaHoaDon) references HoaDon (MaHoaDon),
constraint FK_HoaDonChiTiet_SanPham foreign key (MaSanPham) references SanPham (MaSanPham),
)
go
-- nh?p li?u  b?ng khách hàng 
insert into KHACHHANG (MaKH,HovaTenLot,Ten,Email,DienThoai)
values ('KH01',N'Nguy?n V?n ',N'NINH',N'123 Ba ?ình,Hà n?i','012345679');
insert into HoaDon (MaHoaDon,NgayMuaHang,MaKH,TrangThai)
values ('ph01','2020-1-16','KH01','DangGiaoHang')

