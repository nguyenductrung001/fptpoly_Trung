use QLDA
go


-- Nhập vào MaNV cho biết tuổi của nhân viên này

   if OBJECT_ID('fn_sotuoi') is not NULL
   Drop FUNCTION fn_sotuoi
   GO
   CREATE FUNCTION fn_sotuoi
   (
       @ma NVARCHAR(9) = '001'
   )
   RETURNS INT
   as 
   BEGIN
          RETURN (SELECT DATEDIFF(YEAR,NGSINH, GETDATE()) 
          FROM NHANVIEN
          WHERE MANV like @ma)

END
GO

PRINT N'Tuổi' + cast(dbo.fn_sotuoi('003') as NVARCHAR )

PRINT N'Tuổi' + cast(dbo.fn_sotuoi(DEFAULT) as NVARCHAR )

 -- Nhập vào Manv cho biết số lượng đề án nhân viên này đã tham gia 

IF OBJECT_ID('fn_demdean') is NOT NULL
       DROP FUNCTION fn_demdean
GO
CREATE FUNCTION fn_demdean(@ma nvarchar(9) = '001')
           RETURNS INT
AS
 BEGIN
        RETURN
        (SELECT COUNT(MADA)
           FROM PHANCONG where MA_NVIEN  like @ma)
        
 END
 go

PRINT N'Tổng số đề án là: ' + CAST(dbo.fn_demdean(DEFAULT) as nvarchar) 


--
IF OBJECT_ID('fn_demnv') is NOT NULL
       DROP FUNCTION fn_demnv
GO
CREATE FUNCTION fn_demnv(@phai nvarchar(3) = 'Nam')
           RETURNS INT
AS
 BEGIN
        DECLARE @tongnv INT
        SELECT @tongnv= COUNT(MANV)
        FROM NHANVIEN where PHAI  like @phai 
        RETURN @tongnv
 END
 go

PRINT N'Tổng số nv nam là: ' + CAST(dbo.fn_demnv(DEFAULT) as nvarchar) 

PRINT N'Tổng số nv nữ là: ' + CAST(dbo.fn_demnv(N'Nữ') as nvarchar) 


-- Truyền tham số đầu vào là tên phòng,
--  tính mức lương trung bình của phòng đó,
--   Cho biết họ tên nhân viên (HONV, TENLOT, TENNV) 
-- có mức lương trên mức lương trung bình của phòng đó


if OBJECT_ID('fn_LuongTB') is not null
	drop function fn_LuongTB
go
   create function fn_LuongTB(@TenPhong nvarchar(15) = N'Điều Hành'  )
	Returns @LuongTB table(	
					TenNV nvarchar(47)
	      )
	as
	Begin
		insert into @LuongTB
		select HONV +' '+ TENLOT+' '+ TENNV
              from NHANVIEN  inner join PHONGBAN PB on NHANVIEN.PHG = PB.MAPHG
		where TENPHG like @TenPhong  
                       and luong > (select avg(luong)
                          from NHANVIEN nv2 where PB.MAPHG = nv2.PHG )
		Return 
	End
GO	 

select *
from dbo.fn_LuongTB(DEFAULT)

-- SELECT AVG(LUONG) FROM NHANVIEN WHERE PHG =4
-- SELECT * FROM NHANVIEN WHERE PHG =4


--Tạo các view:
--➢ Hiển thị thông tin HoNV,TenNV,TenPHG, DiaDiemPhg.
--➢ Hiển thị thông tin TenNv, Lương, Tuổi.
--➢ Hiển thị tên phòng ban và họ tên trưởng phòng của phòng ban có đông nhân viên nhất
if OBJECT_ID('VW_ThongTin') is not null
 drop View VW_ThongTin
go
create View VW_ThongTin
AS
 select HONV,TENNV,PHONGBAN.TENPHG,DIADIEM from PHONGBAN inner join DIADIEM_PHG on PHONGBAN.MAPHG = DIADIEM_PHG.MAPHG
						inner join NHANVIEN on PHONGBAN.TENPHG = NHANVIEN.PHG
go
select* from dbo.VW_ThongTin as nvarchar
----------------------------------------------------------------
-- Gía trị vô hướng 
create function Ten_ham (ts1 KDL neu có)
Returns KieuDL vo huong
as
begin
	--cau lệnh 
	Return gia trị vo hương
end
--goi ham
print'' +cast(dbo.Ten_ham(default) as nvarchar)
 -- hàm table đơn giản
 create function Ten_ham(ts1 KDL nếu có)
  return Table
  as
	Return (cau lenh select)
--gọi hàm 
select * from Ten_ham(default)