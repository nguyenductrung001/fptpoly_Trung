USE QLDA
GO
--1 cú pháp :
CREATE PROC tên thủ tục
   @tham_số_1 kiểu dl--tham số đầu vào (nếu có) không ghi chữ input
   @tham_số_2 kiểu dl -- tham số đầu ra (nếu có )ghi chữ output
   AS 
   BEGIN
   --các lệnh
   END
--lưu ý :tham số đầu ra có 2 cách:
--c1:dùng thm số output
--c2:dùng return <số nguyên> trong thân thủ tục
--tham số đầu vào là tham số bắt buộc phải truyền giá trị khi gọi thủ tục
--tham số tùy chọn :
--khi xây dựng thủ tục ta gán giá trị mặc định
--khi gọi thủ tục :ta có thể dùng  giá trị  mặc định (đã gán )nếu không truyền giá trị
--vd1:xây dựng thủ tục tính tổng 2 số nguyên :có 2 tham số đầu vào ,không có đầu ra
--kiểm tra nếu tồn tại =>xóa
IF OBJECT_ID('tinhtong')IS NOT NULL
   DROP PROC tinhtong
go
CREATE PROC tinhtong
   @so1 int,--tham số đầu vào (nếu có) không ghi chữ input
   @so2 int 
AS 
   BEGIN
      DECLARE @tong int
      SET @tong=@so1+@so2
      PRINT N'tổng 2 số là: '+CAST(@tong AS nvarchar)
   END
GO
EXEC dbo.tinhtong 
    @so1 = 5, -- int
    @so2 = 10 -- int
--gọi thủ tục có giá trị mặc định ,không có output:
EXEC ten_thủ_tục --không điền giá trị dùng giá trị mặc định

--gọi thủ tục có output
--khai náo 1 bieenss có kiểu dữ liệu giống của output để nhận kết quả
DECLARE @kq Kiểu_dl_của_tham_số_output 
EXEC tên thủ tục giá trị 1 truyền vào nếu có,...,@kq OUTPUT--@kq đặt đúng vị trí của tham số output
SELECT @kq

--gọi thủ tục có return
DECLARE @kq INT
EXEC @kp=ten giá trị 1 truyền vào nếu có,giá trị 2 truyền vào nếu có
SELECT @kq


--gọi thủ tục vd1
EXEC dbo.tinhtong 4,5
--c2 truền theo tham số
EXEC dbo.tinhtong 
    @so1 = 5, -- int
    @so2 = 10 -- int
	
--vd2 tính tổng 2 số :2 tham số đầu vào ,dùng output
go
CREATE PROC tinhtong2
   @so1 int,--tham số đầu vào (nếu có) không ghi chữ input
   @so2 int ,
   @tong int output
AS 
   BEGIN
      
      SET @tong=@so1+@so2
      
   END
GO
DECLARE @kq INT
EXEC dbo.tinhtong2 6, -- int
    4, -- int
    @kq OUTPUT
SELECT @kq
-- c2 truyền theo tham số
DECLARE @kq INT
EXEC dbo.tinhtong2 @so1=6, -- int
    @so2=4, -- int
    @tong=@kq OUTPUT
SELECT @kq
go
--vd3 dùng return
CREATE PROC tinhtong3
   @so1 int,--tham số đầu vào (nếu có) không ghi chữ input
   @so2 int 
  
AS 
   BEGIN
      
      RETURN @so1+@so2
      
   END
GO
--dùng theo vị trí
DECLARE @kq INT
EXEC @kq=dbo.tinhtong3  2,4
SELECT @kq
--dùng theo tham số
DECLARE @kq INT
EXEC @kq=dbo.tinhtong3 @so1 = 4, -- int
    @so2 = 6 -- int
SELECT @kq
--vd4 
IF OBJECT_ID('tinhtong5')IS NOT NULL
   DROP PROC tinhtong5
go
CREATE PROC tinhtong5
   @so1 INT=10,--tham số đầu vào (nếu có) không ghi chữ input
   @so2 int =5
AS 
   BEGIN
      DECLARE @tong int
      SET @tong=@so1+@so2
      PRINT N'tổng 2 số là: '+CAST(@tong AS nvarchar)
   END
GO
EXEC dbo.tinhtong5 

--vd5 tạo thủ tục ;đầu vào manv .thủ tục tông tin nhân viên theo manv
IF OBJECT_ID('tnnv')IS NOT NULL
   DROP PROC tnnv
   go
CREATE PROC tnnv
@manv nvarchar(9)
AS
  BEGIN
    SELECT *
	FROM dbo.NHANVIEN 
	WHERE MANV LIKE @manv
  END
  go
  EXEC dbo.tnnv @manv = N'001' -- nvarchar(9)
  --vd6 nhập vào @mada cho biết số lượng nhân vien tham gia đề án đó
  IF OBJECT_ID('ttda') IS NOT NULL
  DROP PROC ttda
  GO
  CREATE PROC ttda
  @mada INT,
  @tongnv INT OUTPUT
  AS
  BEGIN
     SELECT @tongnv=COUNT(MA_NVIEN)
     FROM dbo.PHANCONG
     WHERE MADA = @mada
  END
  GO
  DECLARE @kq INT 
  EXEC dbo.ttda 30 ,@kq OUTPUT -- int
  SELECT @kq AS soluong
  GO



  IF OBJECT_ID('ttda') IS NOT NULL
  DROP PROC ttda
  GO
  CREATE PROC ttda
  @mada INT
  AS
  BEGIN
    DECLARE @tongnv int
     SELECT @tongnv=COUNT(MADA)
     FROM dbo.PHANCONG
     WHERE MADA = @mada
	 RETURN @tongnv
  END
  GO
  --theo vị trí
  DECLARE @kq INT 
  EXEC @kq=dbo.ttda  30
  SELECT @kq AS soluong
  GO
  --theo tham số
  DECLARE @kq INT 
  EXEC @kq=dbo.ttda  @mada=30
  SELECT @kq AS soluong
  GO

  SELECT*
  FROM dbo.PHANCONG

  ---------------------------------------------------------------------------
  --II
  --1.Cập nhật thủ tục: thay lệnh create thành alter
  --2. các thủ tục hệ thống:system stored procedures
--VD:
  sp_helptext sp_tinhtong: --xem noi dung
  --3 thủ tục thwm dữ iệu vào bảng
  use QLPT1
  go

  --VD1: tạo thủ tục: thực hiện chèn dữ liệu vào bảng NGUOIDUNG:
 -- Kiểm tra null với cột không chấp nhận thuộc tính null
--kiểm tra khóa chính 
--kiểm tra khoá ngoại
-- 2 lời gọi: thành công, thất bại  
if OBJECT_ID('sp_InsertNGUOIDUNG') is not null 
drop proc sp_InsertNGUOIDUNG
go
create proc sp_InsertNGUOIDUNG

           @MaNguoiDung nvarchar(10) = null, -- gán giá trị mặc định cho nhuqngx cột bắt buộc nhập 
           @TenND nvarchar(30) = null,
           @Gioitinh nvarchar(5),
           @SoDT nvarchar(20),
           @Diachi nvarchar(100),
           @MaQuan nvarchar(10) = null,
           @Email nvarchar(100)

As 
Begin
-- Kiểm tra null với cột không chấp nhận thuộc tính null
if(@MaNguoiDung is null or @TenND is null or @MaQuan is null)
print 'vui lòng nhập MAND,TenND,MaQuan'
--kiểm tra khóa chính 
	else if exists ( select* from NGUOIDUNG where MaNguoiDung =@MaNguoiDung) -- kiểm tra khóa chính
	print N'Khóa chính trùng, không thêm được'
--kiểm tra khoá ngoại
else if not exists ( select* from QUAN where MaQuan =@MaQuan) -- kiểm tra khóa chính
	print N' Lỗi khóa ngoại không thêm được'
	else 
	Begin
		insert into NGUOIDUNG
		values (@MaNguoiDung , 
           @TenND ,
           @Gioitinh,
           @SoDT ,
           @Diachi,
           @MaQuan,
           @Email)
		   print N'thêm thành công'
	end
End
go

use QLPT1
go
-- 2 lời gọi: thành công, thất bại
--thành công
	exec sp_InsertNGUOIDUNG  N'ND018',N'Nguyen Van A',N'Nam',N'987654321',N'Thanh Xuân','Q03',N'ANVPH0000@gmail.com'
--gọi thất bại
exec sp_InsertNGUOIDUNG	N'ND001',N'Nguyen Van A',N'Nam',N'987654321',N'Thanh Xuân','Q03',N'ANVPH0000@gmail.com'
select * from NGUOIDUNG

--------------------------------------------------------------------------
--BÀI TẬP TÍNH ĐIỂM
	use QLDA
	GO
--B1 
if OBJECT_ID('sp_InsertDEAN') is not null 
drop proc sp_InsertDEAN
go
create proc sp_InsertDEAN
           @TENDEAN nvarchar(15) = null ,
           @MADA int,
           @DDIEM_DA nvarchar(15) = null,
           @PHONG int
As       
Begin
if(@TENDEAN is null or @DDIEM_DA is null )
print 'vui lòng nhập TenDEAN,DDIEM_DA'
--kiểm tra khóa chính
	else if exists ( select* from DEAN where MADA =@MADA) -- kiểm tra khóa chính
	print N'Khóa chính trùng, không thêm được'
	--kiểm tra khóa ngoại
	else if not exists ( select* from PHONGBAN where MAPHG =@PHONG) -- kiểm tra khóa chính
	print N' Lỗi khóa ngoại không thêm được'
	else 
	Begin
		insert into DEAN
		values (@TENDEAN , 
           @MADA ,
           @DDIEM_DA ,
           @PHONG )
		   print N'thêm thành công'
	end
end
go

-- 2 lời gọi: thành công, thất bại
--thành công 
exec sp_InsertDEAN N'Sản Phẩm h',5,N'Vũng Tàu',5
-- gọi thất bại
exec sp_InsertDEAN N'Sản Phẩm x',1,N'Vũng Tàu',5
select * from DEAN
--B2
