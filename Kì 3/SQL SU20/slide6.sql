use QLDA
GO
	--Trigger là một dạng đặc biệt của thủ tục lưu trữ (store procedure), 
	--được thực thi một cách tự động khi có sự thay đổi dữ liệu (do tác động của câu lệnh INSERT, UPDATE, DELETE) trên một bảng nào đó. 
	--Không thể gọi thực hiện trực tiếp Trigger bằng lệnh EXECUTE. 
	--Trigger là một stored procedure không có tham số.
--1.Trigger Insert 
--Trigger UPDATE 
--Trigger UPDATE sao chép bản ghi gốc vào bảng Deleted và bản ghi mới vào bảng Inserted 
-- cú pháp:
create trigger tên_trigger on TenBang
for[Insert/Update/Detelte]
as
Begin
--các lệnh 
end
--VD1:: kiểm tra duữ liệu truyền vào 
--bảng nhân viên có lương phải lớn hơn 5000
if OBJECT_ID('tg_Check_LuongNV') Is not null
drop trigger tg_Check_LuongNV
go
create Trigger tg_Check_LuongNV on NHANVIEN
for Insert
as
begin
  if(select luong from inserted)<5000
  Begin
	print N'lương phải lớn hơn 5000'
	ROLLBACK TRAN --
  end
end
--Thử:
	Insert into NHANVIEN
	values(N'LÊ',N'MINH',N'ĐĂNG','018','2001-09-12',N'HÀ NỘI',N'NAM',6000,'001',4) 
SELECT* FROM NHANVIEN
--VD2:Ví dụ trigger cập nhật lương cho nhân viên, quy định lương >5000

if OBJECT_ID('tg_Check_LuongNV_UD') Is not null
   drop trigger tg_Check_LuongNV_UD
go
  create Trigger tg_Check_LuongNV_UD on NHANVIEN
for Update
as
begin
  if(select luong from inserted)<5000
  Begin
	print N'update lương phải lớn hơn 5000'
	ROLLBACK TRAN --
  end
end
--Thử:
	update NHANVIEN
	set LUONG = 8000
	where MANV = '001'
	select*from NHANVIEN
---VD3 trigger delate :  không cho phép xóa nhân viên 018
if OBJECT_ID('tg_DeleteNV010') Is not null
   drop trigger tg_DeleteNV010
go
  create Trigger tg_DeleteNV010 on NHANVIEN
for Delete
as
begin
	if exists (select*from deleted where MANV= '018')
	Begin
		print'không đc xóa con cưng của tôi  '
		ROLLBACK TRAN 
	end
end
--thử 
delete from NHANVIEN
where MANV = '018'

-------------------------------------------------------------------------------------------
--2.trigger After: thi khi hoàn thành các hoat động Insert,Update,Delete.
--cú pháp:
	create trigger tên_trigger on tenbang
	after[Insert/update/Delete]
	as
	Begin
		-- các câu lệnh
	end
--VD1:Viết trigger đếm số lượng nhân viên bị xóa khi có câu lệnh xóa trên bảng nhân viên 
if OBJECT_ID('tg_After_delete_NV') Is not null
   drop trigger tg_After_delete_NV
go
  create Trigger tg_After_delete_NV on NHANVIEN
After Delete
as
begin
	declare @num int 
	select @num =  count(*)
	from deleted
	print N'số nhân viên bị xóa là!' + cast(@num as nvarchar)
end
go

-- Thử
delete from NHANVIEN
where MANV = '021' or MANV = '022'
--select * from NHANVIEN
	--Insert into NHANVIEN
	--values(N'LÊ',N'MINH',N'ĐĂNG','021','2001-09-12',N'HÀ NỘI',N'NAM',6000,'001',4)
	
	--Insert into NHANVIEN
	--values(N'LÊ',N'MINH',N'tit','022','2001-09-12',N'HÀ NỘI',N'NAM',6000,'001',4)  

	------------------------------------------------------------------------------
	--III.TRIGGER INSTEAD OF(Thay thế):được thực thi thay thế cho các hoạt động INSERT, UPDATE hoặc DELETE. 
	delete from NHANVIEN
	where MANV = '001'
	select * from THANNHAN
	select * from NHANVIEN
	-- cú pháp
	create trigger tên_trigger on TenBang
    INSTEAD OF[Insert/Update/Detelte]
   as
   Begin
   --các lệnh 
   end
   --VD1 khi xóa nhân viên => các thân nhân của nhân viên này tự động xóa theo tên bảng thân nhân
   if OBJECT_ID('tg_xoa_NhanVien') Is not null
   drop trigger tg_xoa_NhanVien
  go
  create Trigger tg_xoa_NhanVien on NHANVIEN
   INSTEAD OF Delete
  as
 begin
	delete from THANNHAN
	where MA_NVIEN in (select MANV FROM deleted)

	delete from NHANVIEN
	where MANV in (select MANV from deleted)
end
go
delete from NHANVIEN
	where MANV = '021'
	select * from THANNHAN
	select * from NHANVIEN

