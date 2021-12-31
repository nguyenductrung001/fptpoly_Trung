--bai 5 



USE QLDA
GO



--1 cú pháp

CREATE PROC tên thủ tục 
		@tham so1 kiểu DL, --tham số đầu vào (nếu có ) không ghi chữ INPUT
		@tham so2 kiểu DL OUTPUT --tham số đầu ra (nếu có_ ghi chữ output
		AS 
	BEGIN
	--các lệnh
	END
    
	----lưu í đầu ra có 2 cách
	--c1 dùng tham số OUTPUT
 --   c2 dùng RETURN <số nguyên> trong thân thủ tục


 --tham số đầu vào là tham số bắt buộc truyền giá trị khi gọi thủ tục
 --tham số tùy trọn khi xây dựng thủ tục ta sẽ gán giá trị mặc định VD @tham_so1 kieeurDL = giá trị 
 -- khi gọi thủ tục : ta có thể dùng giá trị mặc định(đã gán ) nếu không truyền giá trị 


 --VD1 xây dựng thủ tục tính tổng 2 số có tham số đầu vào không có đầu ra
 IF OBJECT_ID ('tinh_tong') IS NOT null
 DROP PROC tinhtong

 CREATE PROC tinh_tong 
		@so1 int, 
		@so2 int  
 AS 
 BEGIN
 	DECLARE @tong int
	SET @tong=@so1+@so2
	PRINT N'tổng là' + CAST(@tong AS nvarchar)
 END

 go
 --gọi thủ tục'
 -- gọi thủ tục có giá trị mặc định,không có output
 EXEC ten thủ tục -- không điền giá trị 2 truyền vào nếu có 
EXEC ten_thủ_tục giá_trij1_truyền_vào_nếu có, giá  trị 2 truyền vào nếu có 



-- gọi thủ tục có output 

--khai báo 1 biến có kiểu dữ liệu giống của output để nhận kết quả
DECLARE @kq kiểu DL của tham số OUTPUT
EXEC ten thủ tục giá trị 1 truyền vào nếu có, @kq OUTPUT -- @kq đặt đúng vị trí của tham số output 

go
--gọi thủ tục có return 

DECLARE @kq INT
EXEC @kq= ten_thủ_tục giá_trij1_truyền_vào_nếu có, giá  trị 2 truyền vào nếu có 
 
SELECT @kq
go
--gọi thủ tục vD1
--c1
EXEC tinh_tong 4,5
--c2 truyền theo tham số
EXEC tinh_tong @so1=2,@so2=5


--vd2_ tính tổng 2 tham số đầu vào, dùng output

 IF OBJECT_ID ('tinh_tong1') IS NOT null
 DROP PROC tinh_tong1
 go
 CREATE PROC tinh_tong1 
		@so1 int , 
		@so2 int  ,
		@tong INT OUTPUT
 AS 
 BEGIN
 
	SET @tong=@so1+@so2

 END

 GO


 
 DECLARE @kq INT
 EXEC dbo.tinh_tong1 @so1 = 3, -- int
     @so2 = 4, -- int
     @tong = @kq OUTPUT -- int

 SELECT @kq
   
 --vd3

 --tính tỏng dubgf reutrn
  IF OBJECT_ID('tinh_tong2') IS NOT NULL
    DROP PROC tinh_tong2
 GO
  CREATE PROC tinh_tong2
   @so1 INT,
    @so2 INT
  AS
    BEGIN
 
        RETURN @so1+@so2

    END

 GO

  DECLARE @kq INT
  EXEC @kq = dbo.tinh_tong2 @so1 = 3, -- int
    @so2 = 4
 -- int
  SELECT    @kq AS N'kết quả'



  --vd4 
   IF OBJECT_ID ('tinh_tong3') IS NOT null
 DROP PROC tinh_tong3
 go
 CREATE PROC tinh_tong3
		@so1 int =2, 
		@so2 int =5 
		
 AS 
 BEGIN

	DECLARE @tong int
	SET @tong=@so1+@so2
	PRINT N'tổng là' + CAST(@tong AS nvarchar)

 END

 GO


 EXEC dbo.tinh_tong3 
 
   
 

 --VD5 truy xuất thông tin nhân viên theo mã nhân viên
 --tạo thủ tục : đầu vào maNV 


 GO
 
 IF OBJECT_ID('maNV') IS NOT NULL
    DROP PROC maNv
	GO
 CREATE PROC maNV 
 @manv NVARCHAR(9)
 AS
    BEGIN

        SELECT  *
        FROM    dbo.NHANVIEN
        WHERE   MANV = @manv
    END

 GO
 -- gọi thủ tục
EXEC dbo.maNV @manv = N'008' -- nvarchar(9)


--vd6 ➢ Nhập vào @MaDa (mã đề án), cho biết số lượng nhân viên tham gia đề án đó


go
IF OBJECT_ID('MaDA') IS NOT NULL
    DROP PROC MaDA
	GO
 CREATE PROC MaDA
  @MaDA INT,
  @tong INT OUTPUT
 AS
    BEGIN
	SELECT @tong=
	 COUNT(MA_NVIEN)
	FROM dbo.PHANCONG
	WHERE MADA=@MaDA
	
    END

 GO
 

 DECLARE @kq int
 EXEC dbo.MaDA @MaDA = 3, -- int
     @tong = @kq OUTPUT -- int
	 SELECT @kq
 
 --c2 dùng RETURN
 IF OBJECT_ID('MaDA1') IS NOT NULL
    DROP PROC MaDA1
	GO
 CREATE PROC MaDA1
  @MaDA INT

 AS
   BEGIN
   DECLARE @tongnv INT
  SELECT @tongnv= COUNT(MA_NVIEN)
	FROM dbo.PHANCONG
	WHERE MADA=@MaDA
	RETURN @tongnv
    END

 GO

 
 DECLARE @kq INT
 EXEC @kq=dbo.MaDA1 @MaDA = 3 -- int
 SELECT @kq
 

 --c3 dùng mặc định

  IF OBJECT_ID('MaDA2') IS NOT NULL
    DROP PROC MaDA2
	GO
 CREATE PROC MaDA2
  @MaDA INT =3

 AS
   BEGIN
   DECLARE @tong INT
  SELECT @tong= COUNT(MA_NVIEN)
	FROM dbo.PHANCONG
	WHERE MADA=@MaDA
	 PRINT N'tổng la '+ CAST(@tong AS NVARCHAR)

    END

 GO


 EXEC dbo.MaDA2
 

 