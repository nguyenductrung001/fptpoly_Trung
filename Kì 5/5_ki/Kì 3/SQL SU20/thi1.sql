USE QLNV
GO
-------------------c2---------------------
IF OBJECT_ID('sp_addNhanVien') IS NOT NULL
		DROP PROC sp_addNhanVien
GO
CREATE 	 PROC 	sp_addNhanVien
		  @MaNV nvarchar(10) = null,
           @HoTen nvarchar(50) = null,
           @NgaySinh DATETIME = null,
           @DiaChi nvarchar(50) = null,
           @HSLuong MONEY = null,
           @MaDV nvarchar(10) = null
AS
BEGIN
	IF(   @MaNV  is NULL or
           @HoTen  is NULL or
           @NgaySinh  is NULL or
           @DiaChi  is NULL or
           @HSLuong is NULL or
           @MaDV  is NULL )
		PRINT N'Bnạ phải nhập ddue thông tin!'
	ELSE IF EXISTS(SELECT * FROM NhanVien WHERE MaNV = @MaNV)
	PRINT N'lỗi khóa chính không thêm được'
	ELSE
    INSERT INTO dbo.NhanVien
            ( MaNV ,
              HoTen ,
              NgaySinh ,
              DiaChi ,
              HSLuong ,
              MaDV
            )
    VALUES  ( @MaNV,@HoTen,@NgaySinh,@DiaChi,@HSLuong,@MaDV )
	PRINT N'Thêm thành công!'
END
GO
EXEC   sp_addNhanVien '001',N'ABC','2020-11-11',N'XYZ',0.1,'DV01'
EXEC   sp_addNhanVien '002',N'ABC','2020-11-11',N'XYZ',0.1,'DV02'
EXEC   sp_addNhanVien '003',N'ABC','2020-11-11',N'XYZ',0.1,'DV01'
EXEC   sp_addNhanVien '004',N'XYZ','2020-11-11',N'XYZ',0.1,'DV03'
SELECT * FROM dbo.NhanVien



  -----------------------------------------------------------------

IF OBJECT_ID('sp_addDV') IS NOT NULL
		DROP PROC sp_addDV
GO
CREATE 	 PROC 	sp_addDV
		  @MaDV nvarchar(10) = NULL,
           @TenDV nvarchar(30) = null,
           @DienThoai nvarchar(15)=null
AS
BEGIN
	IF(   @MaDV  is NULL or
           @TenDV  is NULL or
           @DienThoai  is NULL )
		PRINT N'Bnạ phải nhập ddue thông tin!'
	ELSE IF EXISTS(SELECT * FROM dbo.DonVi WHERE MaDV = @MaDV)
	PRINT N'lỗi khóa chính không thêm được'
	ELSE IF NOT EXISTS(SELECT * FROM dbo.NhanVien WHERE MaDV = @MaDV)
	PRINT N'lỗi khóa Ngoại không thêm được'
	ELSE
   INSERT INTO dbo.DonVi
           ( MaDV, TenDV, DienThoai )
   VALUES  ( @MaDV,@TenDV,@DienThoai)
	PRINT N'Thêm thành công!'
END
GO
EXEC   sp_addDV 'DV01',N'ASD','01234456677'
EXEC   sp_addDV 'DV02',N'dcx','0123445666666'
EXEC   sp_addDV 'DV03',N'dcx','0123445666666'

SELECT* FROM dbo.DonVi
----------------------------c4----------------
IF OBJECT_ID('fn_TimMaNV') IS NOT NULL
	DROP FUNCTION	fn_TimMaNV
GO
CREATE FUNCTION fn_TimMaNV
(@MaDV NVARCHAR(10) = 'DV01')
RETURNS TABLE
AS
	RETURN SELECT DonVi.MaDV,TenDV,MaNV,HoTen,NgaySinh,DiaChi FROM dbo.NhanVien INNER JOIN dbo.DonVi ON DonVi.MaDV = NhanVien.MaDV	 WHERE DonVi.MaDV=@MaDV
go
SELECT* FROM  fn_TimMaNV (DEFAULT)
----------------------------C5-----------------------------------------------------
IF OBJECT_ID('VW_Top2DV')IS NOT NULL
	DROP VIEW  VW_Top2DV
GO
CREATE VIEW VW_Top2DV
AS
SELECT TOP 2 DonVi.MaDV,TenDV,DienThoai
 FROM dbo.NhanVien INNER JOIN dbo.DonVi ON DonVi.MaDV = NhanVien.MaDV
 GROUP BY  DonVi.MaDV,TenDV,DienThoai
 ORDER BY COUNT(MaNV) DESC
 go
 SELECT* FROM	VW_Top2DV
 
