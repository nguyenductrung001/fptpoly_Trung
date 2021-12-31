use [QLNV(DEMO)]
go
----cau2
IF OBJECT_ID('SP_AddNV') is not null
	drop proc SP_AddNV
go
create proc SP_AddNV
(
	@MaNV nvarchar(10) = null,
           @HoTen nvarchar(50) = null,
           @MaVP nvarchar(10) = null,
           @NgaySinh datetime = null,
           @GioiTinh nvarchar(3) = null,
           @SoDT nvarchar(15) = null,
           @CMND nvarchar(20) = null
)
as
Begin
	if(@MaNV  is null or
           @HoTen is null or
           @MaVP is null or
           @NgaySinh is null or
           @GioiTinh is null or
           @SoDT is null or
           @CMND is null )
		   print N'Bạn phải nhập đủ dữ liệu!'
	else if exists(select* from NhanVien where MaNV = @MaNV)
	     print N'Lỗi khóa chính không thêm được'
	else
	insert into NhanVien(MaNV,HoTen,MaVP,NgaySinh,GioiTinh,SoDT,CMND)
	     values (@MaNV,@HoTen,@MaVP,@NgaySinh,@GioiTinh,@SoDT,@CMND)
	Print N'Thêm thành công'
End
go
exec SP_AddNV '001','ABC','vp1','2001-01-01',N'Nam','0123456789','03030303030303'
exec SP_AddNV '002','XYZ','vp1','2001-01-01',N'Nữ','012345678999','020202020202'
----------------------------------------------------------------------------------
IF OBJECT_ID('SP_AddNhanThan') is not null
	drop proc SP_AddNhanThan
go
create proc SP_AddNhanThan
(
	      @MaNhanThan nvarchar(10) = null,
           @MaNV nvarchar(10) = null,
           @HoTen nvarchar(50) = null,
           @NgaySinh datetime = null,
           @MoiLienHe nvarchar(30) = null
)
as
Begin
	if(@MaNhanThan  is null or
           @MaNV is null or
           @HoTen is null or
           @NgaySinh is null or
           @MoiLienHe is null
            )
		   print N'Bạn phải nhập đủ dữ liệu!'
	else if exists(select* from NhanThan where MaNhanThan = @MaNhanThan)
	     print N'Lỗi khóa chính không thêm được'
	else if not exists(select* from NhanVien where MaNV = @MaNV)
	     print N'Lỗi khóa Ngoại không thêm được'
	else
	insert into NhanThan
	     values (@MaNhanThan,@MaNV,@HoTen,@NgaySinh,@MoiLienHe)
	Print N'Thêm thành công'
End
go
exec SP_AddNhanThan 'NT01','001',N'OBZ','1999-01-01',N'BỐ'
exec SP_AddNhanThan 'NT02','001',N'OBy','1999-01-01',N'Mẹ'
select * from NhanThan
select* from NhanVien
--Cau3
if OBJECT_ID('Fn_TongNT') is not null 
	drop proc Fn_TongNT
go
create function Fn_TongNT
(
	@MaNV nvarchar(10) = '001'
)
returns int 
As
Begin
return (select count(MaNhanThan) from NhanThan where MaNV =@MaNV)
End
Go
print N'Tổng số nhân thân là:' + cast(dbo.Fn_TongNT(default) as nvarchar)

--------------------Cau4-----------------------------
if OBJECT_ID('sp_deleteTN') is not null
	drop proc sp_deleteTN
Go
create proc sp_deleteTN
(
@MaNV nvarchar(10)

)
As 
Begin
	Begin Try
	Begin Tran
		Delete from NhanThan where MaNV = @MaNV
		delete from NhanVien where MaNV = @MaNV
		print N'Xóa dữ lieeuh thành công'
	 Commit Tran
	End Try 
	Begin catch
			rollback Tran
		Print N'Xóa dữ liệu thất bại'
	End Catch
End
Go
exec sp_deleteTN '001'
select * from NhanVien
select * from NhanThan

---------------------Cau5-------------------
if OBJECT_ID('VW_Top2NV') is not null
	drop view VW_Top2NV
go
create view VW_Top2NV
As
select top 2 NhanVien.MaNV,NhanVien.HoTen, MaVP,NhanVien.NgaySinh,GioiTinh,SoDT,CMND 
from NhanVien left join NhanThan on NhanVien.MaNV = NhanThan.MaNV
group by NhanVien.MaNV,NhanVien.HoTen, MaVP,NhanVien.NgaySinh,GioiTinh,SoDT,CMND 
order by count(MaNhanThan) desc
go
select * from VW_Top2NV