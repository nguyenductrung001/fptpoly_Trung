use BanHang3
go
------------------------------cau2-----------------------------------------------------------------------
if OBJECT_ID('sp_AddKhachHang') is not null
drop proc sp_AddKhachHang
go
create proc sp_AddKhachHang1
(
	       @MaKH nvarchar(10),
           @TenKH nvarchar(50) = null,
           @DiaChi nvarchar(50) = null,
           @DienThoai nvarchar(15) = null,
           @GioiTinh nvarchar(3) = null
)
as
Begin
	if( @MaKH is null or
           @TenKH  is null or
           @DiaChi is null or
           @DienThoai is null or
           @GioiTinh  is null)
	print N'Mời bạn nhập đủ thông tin!'
	else if exists(select* from KhachHang where MaKH = @MaKH)
	print N'Lỗi khóa chính không thêm được'
	else
	Begin
		insert into KhachHang
		values (@MaKH,@TenKH,@DiaChi,@DienThoai,@GioiTinh)
		print N'Thêm thành công'
	end
end
go 
exec sp_AddKhachHang '009' , N'ABC',N'XYZ','0123484848',N'NAM'
exec sp_AddKhachHang '002' , N'ABC',N'XYZ','0123484849',N'Nữ'
-----------------------------------cau 2b------------------------------------------------------------------
if OBJECT_ID('sp_AddDonHang') is not null
drop proc sp_AddDonHang
go
create proc sp_AddDonHang
(
	       @MaDH nvarchar(10) = null,
           @NgayDH datetime = null,
           @NgayGiaoHang datetime = null,
           @MaKH nvarchar(10) = null
)
as
Begin
	if( @MaDH is null or
           @NgayDH  is null or
           @NgayGiaoHang is null or
           @MaKH is null )
	print N'Mời bạn nhập đủ thông tin!'
	else if exists(select* from DonDH where MaDH = @MaDH)
	print N'Lỗi khóa chính không thêm được'
	else if not exists(select* from KhachHang where MaKH = @MaKH)
	print N'Lỗi khóa ngoại không thêm được'
	else
	Begin
		insert into DonDH
		values (@MaDH,@NgayDH,@NgayGiaoHang,@MaKH)
		print N'Thêm thành công'
	end
end
go
exec sp_AddDonHang '002','2020-11-11','2020-11-12','001'
exec sp_AddDonHang '003','2020-11-11','2020-11-12','002'
----------------------------Cau3-----------------------------------------------------------
3

If OBJECT_ID('fn_CountMuaHang') is not null
	drop function fn_CountMuaHang
go
create function fn_CountMuaHang
(
	@MaKH nvarchar(10) = '001'
)
returns int 
as
Begin
	declare @kq int
	select @kq=  count(MaDH) from DonDH
	where MaKH = @MaKH
	Return @kq
End
go
print N'tổng số lần mua hàng của khách hàng đó là:' + cast(dbo.fn_CountMuaHang(Default) as nvarchar)
select * from KhachHang
select* from DonDH
------------------------------------------------------Cau4----------------------------------------------------------------
If OBJECT_ID('sp_Delete') is not null
	drop proc sp_Delete
go
create proc sp_Delete

	@MaKH nvarchar(10) = '001'

as
begin
Begin try
begin tran
		Delete from DonDH where MaKH like @MaKH
		delete from KhachHang where MaKH like @MaKH
		print N'Xoa thanh cong'
	commit tran
End try
begin catch
	rollback trAN
	print'xoa that bai'
end catch
End
go
exec sp_Delete '001'
SELEct * from KhachHang
select * from DonDH
-------------------------------------------------------cau5----------------------------------------------------------------
if OBJECT_ID('sp_TimKiem') is not null
	drop proc sp_TimKiem
go
create proc sp_TimKiem
@time1 date = null,
@time2 date = null
as
Begin
	if @time1 is null
	set @time1 = '2020-11-11'
	if @time2 is null
	set @time2 = '2020-11-12'
End