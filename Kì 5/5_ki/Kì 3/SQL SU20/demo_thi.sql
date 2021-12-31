USE QLNV1
go
------Cau2-----------
IF OBJECT_ID('sp_addNV') IS NOT NULL
	DROP PROC	 sp_addNV
GO
CREATE PROC    sp_addNV
	@MaNV nvarchar(50),
           @HoTen nvarchar(50) = null,
           @NgaySinh DATE = null,
           @DiaChi nvarchar(50) = null,
           @DienThoai nvarchar(15) = null,
           @HSLuong MONEY = null,
           @MaDV nvarchar(10) = null
AS
BEGIN
   BEGIN
		IF(@HoTen IS NULL OR @NgaySinh IS NULL OR @DiaChi IS NULL OR @DienThoai IS NULL OR @HSLuong IS NULL OR @MaDV IS NULL )
			PRINT N'Ban phai nhap du thong tin!'
		ELSE IF EXISTS(SELECT* FROM dbo.NhanVien WHERE MaNV =@MaNV)
			PRINT N'Loi khoa chinh khong them duoc!'
			ELSE IF not EXISTS(SELECT* FROM dbo.DonVi WHERE MaDV =@MaDV)
			PRINT N'Loi khoa ngoai khong them duoc!'
		ELSE
			INSERT INTO dbo.NhanVien
			        ( MaNV ,
			          HoTen ,
			          NgaySinh ,
			          DiaChi ,
			          DienThoai ,
			          HSLuong ,
			          MaDV
			        )
			VALUES  ( @MaNV,@HoTen,@NgaySinh,@DiaChi,@DienThoai,@HSLuong,@MaDV )
			PRINT N'Them thanh cong'
    END
END
GO
EXEC  sp_addNV 'NV01',N'ABC','2002-11-11','XYZ','03339999333',1.2,'DV01'
EXEC  sp_addNV 'NV02',N'DEF','2003-11-1','GHK','0444444444',1.5,'DV02'
EXEC  sp_addNV 'NV03',N'DEF','2003-11-1','xxx','0444444444',1.5,'DV02'
SELECT * FROM dbo.NhanVien
----------------------------------------


IF OBJECT_ID('sp_addDV') IS NOT NULL
	DROP PROC	 sp_addDV
GO
CREATE PROC    sp_addDV
	       @MaDV nvarchar(10) = null,
           @TenDV nvarchar(50) = null,
           @DienThoai nvarchar(15) = null
AS
BEGIN
   BEGIN
		IF(@MaDV IS NULL OR @TenDV IS NULL OR @DienThoai IS NULL  )
			PRINT N'Ban phai nhap du thong tin!'
		ELSE IF EXISTS(SELECT* FROM dbo.DonVi WHERE MaDV =@MaDV)
			PRINT N'Loi khoa chinh khong them duoc!'
		ELSE
			INSERT INTO dbo.DonVi
			        ( MaDV, TenDV, DienThoai )
			VALUES  ( @MaDV,@TenDV,@DienThoai
			          )
			PRINT N'Them thanh cong'
    END
END
GO
EXEC  sp_addDV 'DV01' ,N'QUANSU','0123345678'
EXEC  sp_addDV 'DV02' ,N'CHINHTRI','113'
SELECT* FROM dbo.DonVi
---------------Cau3---------------------
	IF OBJECT_ID('sp_DeleteTT') IS NOT NULL
		DROP PROC 	sp_DeleteTT
	GO
    CREATE PROC sp_DeleteTT
		@SO INT  = 0 
	AS
	BEGIN
		DECLARE @Bang TABLE(
					 MaDV nvarchar(10)
		)
		INSERT INTO @Bang
		SELECT dbo.DonVi.MaDV FROM dbo.DonVi	LEFT JOIN dbo.NhanVien ON NhanVien.MaDV = DonVi.MaDV
					GROUP BY DonVi.MaDV
					HAVING COUNT(dbo.NhanVien.MaNV) < @SO
		BEGIN try
			 BEGIN TRAN
				 DELETE FROM dbo.NhanVien WHERE MaDV IN (SELECT MaDV FROM @Bang)
				 DELETE FROM dbo.DonVi WHERE MaDV IN (SELECT MaDV FROM @Bang)
				 PRINT N'Xoa thanh cong'
			 COMMIT TRAN
        END try
		BEGIN CATCH
			  ROLLBACK 	TRAN
			  PRINT	N'xoa that bai'
		END CATCH
	END
	Go
EXEC  sp_DeleteTT 2
	
-------------=---cau4----------------------
IF OBJECT_ID('fn_MaDV') IS NOT NULL
	DROP FUNCTION 	fn_MaDV
GO
CREATE FUNCTION fn_MaDV
(@MaDv NVARCHAR(10) = 'DV01')
RETURNS TABLE
AS
	RETURN (SELECT dbo.DonVi.MaDV,TenDV,MaNV,HoTen,NgaySinh,DiaChi FROM dbo.DonVi INNER JOIN dbo.NhanVien ON NhanVien.MaDV = DonVi.MaDV
	                 WHERE DonVi.MaDV = @MaDv)
GO
SELECT* FROM fn_MaDV(DEFAULT)
--------------------Cau5--------------------------------
IF OBJECT_ID('Vw_Top2') IS NOT NULL
	DROP VIEW  Vw_Top2
GO
CREATE VIEW Vw_Top2
AS
	SELECT TOP 2 DonVi.MaDV,TenDV,DonVi.DienThoai
	 FROM dbo.DonVi INNER JOIN dbo.NhanVien ON NhanVien.MaDV = DonVi.MaDV
	 WHERE DiaChi LIKE N'%Ha Noi%'
	 GROUP BY  DonVi.MaDV,TenDV,DonVi.DienThoai
	 ORDER BY COUNT(DonVi.MaDV)	DESC
Go
SELECT* FROM  Vw_Top2
