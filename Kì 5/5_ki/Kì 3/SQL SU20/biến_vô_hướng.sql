use QLDA
go
--I.biến vô hướng
--1.Biến vô hướng (Luu giá trị đơn)
-- khai báo Declare @tenbien Ki?udl,@tenbien2 kieuDL
-- Gán giá tr?:
--+ set @tenbien = bi?u th?c 
--+ select @tenbien = bi?u th?c
---Truy xuất t: select @tenbien
--BT1 dung biến vô hướng tính chu vi và diện tích hình chữ nhật
Declare @chieu_dai int,@chieu_rong int , @chu_vi int , @dien_tich int
-- gán giá trị 
set @chieu_dai = 10
select @chieu_rong = 5
set @chu_vi=(@chieu_dai + @chieu_rong)*2
set @dien_tich = @chieu_dai*@chieu_rong
-- truy xuất
select @chu_vi as chuvi
select @dien_tich as dientich

print 'Chu vi:' + cast(@chu_vi as nvarchar) -- cast: chuyen chu vi thanh chuoi
print 'Dien tich' + cast(@dien_tich as nvarchar)

--VD2: dùng biến vô hướng cho biết tổng  số nhân viên 
declare @tongNV int 
select @tongNV = count(MANV)
from NHANVIEN
--  truy xuat
print 'tong so nhan vien la:' + cast(@tongNV as nvarchar)

--II.biến bảng

--- khai báo: Declare @tenbang table
--(
	--ten cot kieuDL,
	--ten cot 2 kieuDL
--)
--==> coi @tenbang nhu là bảng 
--==> thực hiện select,insert,update,delete với @tenbang
--==> không dùng select ...imto @tenbang
--VD tạo biến bảng chứa các nhân viên ở HCM
Declare @TableNV table
(
	MaNV nvarchar(9),
	Hoten nvarchar(50)
)
insert into @TableNV
select MANV , HONV+' ' +TENLOT + ' ' + TENNV
from NHANVIEN 
where DCHI like N'%HCM' 
--truy xuất
select*
from @TableNV
 where MANV like '001'

 -- dùng biến vô hướng cho biết lương cao nhất của nhân viên 
 Declare @max_luong Float
 Select @max_luong = MAX(Luong)
 From NHANVIEN
 print 'Nhan vien co luong cao nhat la:' + cast (@max_luong as nvarchar)
 -- dug biên bảng tạo biến bảng chua thong tin cac nhan vien sinh nam 1960
declare @NV table
(
	HONV	nvarchar(15),
	TENLOT	nvarchar(15)	,
	TENNV	nvarchar(15),	
	MANV	nvarchar(9)	,
	NGSINH	datetime	,
	DCHI	nvarchar(30),	
	PHAI	nvarchar(3)	,
	LUONG	float	,
	MA_NQL	nvarchar(9)	,
	PHG	int	
)
insert into @NV
select HONV,TENLOT,TENNV,MANV,NGSINH,DCHI,PHAI,LUONG,MA_NQL,PHG
from NHANVIEN
where YEAR (NGSINH) = 1960
select * from @NV

