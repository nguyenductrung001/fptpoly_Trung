use QLDA
go
--1. các hàm chuyển đổi kiểu dữ liệu
--a chuyển đổi ngầm (tự động chuyển kiểu thấp đến cao)
--b chuyển đổi tường minh dùng cast hoặc convert
-- *cú pháp: cast(biểu thức as kiểu_DL)\


--VD1
select MANV,TENNV,NGSINH,LUONG,
	cast(ngsinh as nvarchar) as ngsinh1,
	cast(LUONG as int) as LuongInt,
	cast(LUONG as nvarchar) as LuongChuoi
from NHANVIEN
--Vd2 dùng biến vô hướng tính tổng lương và in ra 
--Declare @tongluong float
--Select  @tongluong = Sum(LUONG)
--From NHANVIEN
--print N'tổng lương nhân viên là:'+ cast(@tongluong as nvarchar)
---------------------------------------------------------------------------------
--*convert: chyển đổi tường minh
-- cú pháp: convert(kiểu_dữ_liệu, biểu thức[,định dạng])
-- Định dạng khi chyển số sang chuỗi:xem linh:https://docs.microsoft.com/en-us/sql/t-sql/functions/cast-and-convert-transact-sql?redirectedfrom=MSDN&view=sql-server-ver15&fbclid=IwAR3K2QcyDDHiw15BmL9Ke2tEPVaj4M78nvJiRtuCU1hdhO4aPJ0r4Dutw-Y
--VD1 giống VD2 ở trên
Declare @tongluong float
Select  @tongluong = Sum(LUONG)
From NHANVIEN
print N'tổng lương nhân viên là:'+ convert( nvarchar,@tongluong)
print N'tổng lương nhân viên là:'+ convert( nvarchar,@tongluong,1)

--VD2:
select MANV,TENNV, CONVERT(nvarchar,NGSINH,101) as 'mm/dd/yyyy',
					CONVERT(nvarchar,NGSINH,103) as 'dd/mm/yyyy',
					CONVERT(nvarchar,NGSINH,105)as 'dd-mm-yyyy',
					CONVERT(nvarchar,NGSINH,107)as cot4,
					CONVERT(nvarchar,NGSINH,110) as'mm-dd-yyyy'
from NHANVIEN
--VD3
declare @tien money
set @tien = 17000.789

select @tien as cot1,
				CONVERT(nvarchar,@tien) as cot2,
				CONVERT(nvarchar,@tien,1) as cot3,
				CONVERT(nvarchar,@tien,2) as cot4
-----------------------------------------------------------------------------------------------------------------
--2 các hàm toán học 
select SQRT(9) as CanBac2Cua9,
ROUND(4.564,1) as lamtron1sothapphan,
ROUND(4.564,2) as lamtron2sothapphan
-----------------------------------
--3 các hàm sử lý chuỗi(slide21)
select len(' SPT POLYTECNIC ') AS kichthuoc,
LTRIM(' SPT POLYTECNIC ') as catTRangBenTrai,
RTRIM(' SPT POLYTECNIC ') as catTrangBenPhai,
LTRIM(RTRIM(' SPT POLYTECNIC ')) as chuanHoa,
LEFT ('Ha Noi',2) as layChuoiBenTrai,
RIGHT('Ha Noi',3) as layChuoiBenPhai
--SUBSTRING(chuỗi cha , vị trí bắt đầu, số kí tự cần lấy): lấy chuỗi con 
--vd
select SUBSTRING('FPT POLYTECNIC',4,8)--> polytec

--charindex(Chuỗi con , chuỗi cha [, vị trí bắt đầu tìm ]): Tìm vị trí  xuất hiện của chuỗi con trong chuỗi cha
--VD 
select CHARINDEX('ER','SQL SERVER') as timTuDau,
		CHARINDEX('ER','SQL SERVER',7) as timTuViTri7,
		CHARINDEX('abc','SQL SERVER') as KhongTimThay,
		CHARINDEX('sql','SQL SERVER')

--THay thế Replace( chuỗi cha , chuỗi con, chuỗi thay thế)
VD select REPLACE(' nguyen duc trung','nguyen','tran')
--III các hàm ngày tháng năm
--Getdate trả về ngày tháng năm hiện tại 
select GETDATE() 
---
select GETDATE(),CONVERT(date,GETDATE()) as NgayHienTai
-- ngày
select MANV,TENNV,NGSINH,DAY(NGSINH) AS ngay,MONTH(NGSINH) as thang,YEAR(NGSINH) as nam
from NHANVIEN
-- datename: truy cập  tới các tha hf phần liên qyan đến ngày tháng 
select DATENAME(YEAR,GETDATE()) as nam ,
		DATENAME(MONTH,GETDATE()) as thang,
		DATENAME(DAY,GETDATE())as ngay,
		DATENAME(WEEKDAY,GETDATE()) as thu,
		DATENAME(WEEK,GETDATE()) as tuan,
		DATENAME(HOUR,GETDATE()) as giờ

select MANV,TENNV,NGSINH,DATENAME(WEEKDAY,NGSINH) as thứSinh
from NHANVIEN

--DateADD(datepart,number,date): cộng thêm các thành phần ngày tháng vào ngày 
select  DATEADD(YEAR,2,GETDATE()) as cộngThêm2năm,
		 DATEADD(MONTH,2,GETDATE()) as cộngThêm2Tháng,
		  DATEADD(DAY,2,GETDATE()) as cộngThêm2ngày
----Datediff(datepart,number,date): phép trừ 2 ngày => trả kết qur thành phần datepart
select MANV,NGSINH,DATEDIFF(YEAR,NGSINH,GETDATE()) as tuoi,
					DATEDIFF(MONTH,NGSINH,GETDATE()) as tuoi
from NHANVIEN 

Declare @tongDA  int
Select @tongDA = count(	MADA)
from PHANCONG
where MA_NVIEN like '001'
--select @tongDA as deANNV001
print 'tong so de an la:'+ cast (@tongDA as nvarchar)
print 'tong so de an C2 la:'+ convert (nvarchar,@tongDA) 
--B2
Declare @Thongtin table
(
MANV nvarchar(9) ,
TongDA int 
)
--đổ dữ liệu vào bảng 
insert into @Thongtin
select NHANVIEN.MANV, count(MADA) as tongSoDA
from NHANVIEN left outer join PHANCONG ON NHANVIEN.MANV = PHANCONG.MA_NVIEN
group by NHANVIEN.MANV
-- truy xuất:
select NHANVIEN.MANV,UPPER(TENNV) as ten,CONVERT(nvarchar ,NGSINH,103) as ngaysinh, YEAR(GETDATE()) - YEAR(NGSINH) as tuoi,TongDA
		
from NHANVIEN inner join @Thongtin TT on NHANVIEN.MANV = TT.MANV

--SELECT cast(123.2 as decimal(6,2)),
  select DATEDIFF(month, '2008-09-30', '2007-12-01') 
  DECLARE @FullName VarChar(25) SET @FullName = 'www.poly.edu.vn' SELECT SUBSTRING(@FullName, 5, 4)
  
 