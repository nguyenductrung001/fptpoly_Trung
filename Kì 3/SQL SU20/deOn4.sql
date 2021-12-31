use QLSV
go
-- Tạo Stored Procedure (SP) với các tham số đầu vào phù hợp.
--SP thứ nhất thực hiện chèn dữ liệu vào bảng SINHVIEN.
	if OBJECT_ID('sp_AddSinhVien') is not null
		drop proc sp_AddSinhVien
	go
	create proc sp_AddSinhVien
	(
		@MaSV nvarchar(10) = null,
           @HoTen nvarchar(50) = null,
           @NgaySinh datetime = null,
           @GioiTinh nvarchar(3) = null,
           @Lop nvarchar(2) = null
	)
	As
	Begin
		if(@MaSV  is null or
            @HoTen  is null or
           @NgaySinh  is null or
           @GioiTinh  is null or 
           @Lop is null)
		   print N'Mời bạn nhập đủ thông tin!'
		   else if exists(select* from SinhVien where MaSV = @MaSV)
		    print N'Lỗi khóa chính không thêm được!'
		else 
		Begin
		     insert into SinhVien 
			values (@MaSV ,@HoTen,@NgaySinh,@GioiTinh,@Lop)
			print N'Thêm thành công!'
		end						 
	end
	go
	exec sp_AddSinhVien  '001' ,N'Cao Ba Trung' , '2020-11-11' ,N'Nam','12'
	select* from SinhVien
--SP thứ hai thực hiện chèn dữ liệu vào bảng MONHOC.
	if OBJECT_ID('sp_AddMonHoc') is not null
		drop proc sp_AddMonHoc
	go
	create proc sp_AddMonHoc
	(
		@MaMonHoc nvarchar(10) = null,
           @TenMonHoc nvarchar(30) = null,
           @SoTinChi nvarchar(30) = null
	)
	As
	Begin
		if(@MaMonHoc  is null or
            @TenMonHoc  is null or
           @SoTinChi  is null 
           )
		   print N'Mời bạn nhập đủ thông tin!'
		   else if exists(select* from MonHoc where MaMonHoc = @MaMonHoc)
		    print N'Lỗi khóa chính không thêm được!'
		else 
		Begin
		     insert into MonHoc 
			values (@MaMonHoc ,@TenMonHoc,@SoTinChi)
			print N'Thêm thành công!'
		end						 
	end
	go
	exec sp_AddMonHoc '002' , N'IT' , '15'
--SP thứ ba thực hiện chèn dữ liệu vào bảng DIEM.
	if OBJECT_ID('sp_AddDiem') is not null
		drop proc sp_AddDiem
	go
	create proc sp_AddDiem
	(
		   @MaSV nvarchar(10) = null,
           @MaMonHoc nvarchar(10) = null,
           @DiemLan1 nvarchar(10) = null,
           @DiemLan2 nvarchar(10) = null
	)
	As
	Begin
		if(@MaSV  is null or
            @MaMonHoc  is null or
           @DiemLan1  is null or
		    @DiemLan2  is null 
           )
		   print N'Mời bạn nhập đủ thông tin!'
		   else if exists(select* from Diem where MaSV = @MaSV)
		      print N'Lỗi khóa chính ở MaSV không thêm được!'
		   else if exists(select* from Diem where MaMonHoc = @MaMonHoc)
		      print N'Lỗi khóa chính ở MaMonHoc không thêm được!'
		   Else if not exists(select*from SinhVien where MaSV = @MaSV)
		   print N'Lỗi Khóa ngoại ở bảng sinh viên không thêm được'
		    Else if not exists(select*from MonHoc where MaMonHoc = @MaMonHoc)
		   print N'Lỗi Khóa ngoại ở bảng môn học  không thêm được'
		else 
		Begin
		     insert into Diem 
			values (@MaSV ,@MaMonHoc,@DiemLan1,@DiemLan2)
			print N'Thêm thành công!'
		end						 
	end
	go

	exec sp_AddDiem '001' , '002' , '9','9'
	select * from Diem
-- Yêu cầu mỗi SP phải kiểm tra tham số đầu vào. Với các cột không chấp nhận thuộc tính Null.
-- Với mỗi SP viết 3 lời gọi thành công.
--Câu 3: (2 điểm) Viết hàm các tham số đầu vào tương ứng với các cột của bảng Sinhvien. 
                  --Hàm này trả về mã sinh viên (giá trị của cột khóa chính của bảng Sinhvien) 
				  --thỏa mãn các giá trị được truyền tham số.
if OBJECT_ID('fn_Sinhvien')is not null
	drop function fn_Sinhvien
go
create function fn_Sinhvien
(
	       
           @HoTen nvarchar(50) = N'%',
           @NgaySinh nvarchar = N'%',
           @GioiTinh nvarchar(3) = N'%',
           @Lop nvarchar(2) = N'%'
)
Returns table
As
Return (select MaSV from SinhVien where HoTen like @HoTen
										and NgaySinh like @NgaySinh
										and GioiTinh like @GioiTinh
										and Lop like @Lop)
go

select*
from dbo.fn_Sinhvien (default,default,default,default)

--Câu 4: (1.5 điểm) Tạo View lưu thông tin của TOP 2 sinh viên có điểm thi lớn nhất gồm: Masv, Hotensv, tenmh, lanthi, diem. 
if OBJECT_ID('Vw_Top2SV') is not null
	drop View Vw_Top2SV
go
create view Vw_Top2SV
as
	select top 2 SinhVien.MaSV,HoTen,TenMonHoc,  
	iif (DiemLan2  >= DiemLan1,'Lan2','lan1') as LanThi,
	 iif (DiemLan2  >= DiemLan1,DiemLan2,DiemLan1)as diemthi
	 from Diem inner join SinhVien on Diem.MaSV = SinhVien.MaSV
						inner join MonHoc on Diem.MaMonHoc = MonHoc.MaMonHoc 
	order by diemthi desc
go
select*
from Vw_Top2SV

