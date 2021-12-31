USE QLDA
GO

--1. Cho biêt nhân viên có lương cao nhất
DECLARE @luongcao FLOAT
 
 SELECT @luongcao= MAX(LUONG)
 FROM dbo.NHANVIEN

 PRINT 'luong cao nhat la :' + CAST(@luongcao AS NVARCHAR)
--2. Cho biết họ tên nhân viên (HONV, TENLOT, TENNV) có mức lương
--trên mức lương trung bình của phòng "Nghiên cứu”
DECLARE @luongTB FLOAT

 SELECT @luongTB= AVG(LUONG)
 FROM dbo.NHANVIEN
 WHERE PHG=5
 PRINT'luong trung binh :'+CAST(@luongTB AS NVARCHAR)
 DECLARE @nhanvien TABLE
 (
 
 MANV NVARCHAR(9),
 Hoten NVARCHAR(50)

 )
 INSERT INTO @nhanvien

 SELECT  MANV,HONV+''+TENLOT+''+TENNV AS hoten
 FROM dbo.NHANVIEN
 WHERE LUONG>@luongTB

 SELECT *
 FROM @nhanvien

--3. Với các phòng ban có mức lương trung bình trên 30,000, liệt kê tên
--phòng ban và số lượng nhân viên của phòng ban đó.

Declare @luongTB4 float
select @luongTB4=Avg(LUONG)
from NHANVIEN
print N'lương tb4 : ' + cast(@luongTB4 as nvarchar)

select TENPHG,count(MANV) as Soluong
from NHANVIEN left join PHONGBAN on NHANVIEN.PHG=PHONGBAN.MAPHG
where  @luongTB4>30000
group by TENPHG
--4. Với mỗi phòng ban, cho biết tên phòng ban và số lượng đề án mà
--phòng ban đó chủ trì

Declare @soluongDA1 float
select @soluongDA1 = count(PHONG)
from DEAN

print N'Số lượng : ' + cast(@soluongDA1 as nvarchar)
select TENPHG,count(PHONG) as soluongdean
from PHONGBAN inner join DEAN on PHONGBAN.MAPHG=DEAN.PHONG
group by TENPHG