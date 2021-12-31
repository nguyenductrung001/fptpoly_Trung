USE QLDA
GO

-- Bài 1: (3 điểm)
-- Viết stored-procedure:
-- ➢ In ra dòng ‘Xin chào’ + @ten với @ten là tham số đầu vào là tên Tiếng Việt có dấu của
-- bạn. Gợi ý:
-- o sử dụng UniKey để gõ Tiếng Việt ♦
-- o chuỗi unicode phải bắt đầu bởi N (vd: N’Tiếng Việt’) ♦
-- o dùng hàm cast (<biểuThức> as <kiểu>) để đổi thành kiểu <kiểu> của<biểuThức>.
IF OBJECT_ID('PRINT_HELLO') IS NOT NULL DROP PROC PRINT_HELLO
GO

CREATE PROCEDURE PRINT_HELLO
    @ten NVARCHAR(16)
AS
BEGIN
    PRINT N'Xin chào ' + @ten
END
GO
EXEC PRINT_HELLO N'Hùng'

-- ➢ Nhập vào 2 số @s1,@s2. In ra câu ‘Tổng là : @tg’ với @tg=@s1+@s2.
IF OBJECT_ID('PRINT_SUM') IS NOT NULL DROP PROC PRINT_SUM
GO

CREATE PROCEDURE PRINT_SUM
    @num1 int,
    @num2 int
AS
BEGIN
    DECLARE @sum INT
    set @sum = @num1 +@num2
    PRINT N'Tổng là: ' + CAST(@sum AS NVARCHAR)
END
GO

EXEC PRINT_SUM 2,4

-- ➢ Nhập vào số nguyên @n. In ra tổng các số chẵn từ 1 đến @n.
IF OBJECT_ID('PRINT_EVEN') IS NOT NULL DROP PROC PRINT_EVEN
GO

CREATE PROCEDURE PRINT_EVEN
    @num int
AS
BEGIN
    DECLARE @dem INT
    set @dem = 2
    PRINT N'Số Chẵn Từ 1 đến ' + CAST(@num AS NVARCHAR) + N' Là:'
    WHILE (@dem <= @num)
    BEGIN
        IF (@dem % 2 = 0)
            PRINT CAST(@dem AS NVARCHAR(10)) + ' '
        SET @dem +=1
    END
END
GO

EXEC PRINT_EVEN 10

-- ➢ Nhập vào 2 số. In ra ước chung lớn nhất của chúng theo gợi ý dưới đây:
-- o b1. Không mất tính tổng quát giả sử a <= A
-- o b2. Nếu A chia hết cho a thì : (a,A) = a ngược lại : (a,A) = (A%a,a) hoặc (a,A) =
-- (a,A-a)
-- o b3. Lặp lại b1,b2 cho đến khi điều kiện trong b2 được thỏa
IF OBJECT_ID('UCLN') IS NOT NULL DROP PROC UCLN
GO
CREATE PROCEDURE UCLN
    @num1 INT,
    @num2 INT
AS
BEGIN
    PRINT N'ƯỚC CHUNG LƠN NHẤT CỦA HAI SỐ ' + CAST(@num1 AS NVARCHAR(10)) + N' VÀ ' 
            + CAST(@num1 AS NVARCHAR(10)) + N' LÀ: '
    WHILE(@num1 != @num2)
    BEGIN
        IF (@num1>@num2)
            SET @num1 -= @num2
        ELSE IF (@num2>@num1)
            SET @num2 -= @num1
    END
    PRINT CAST(@num1 as NVARCHAR(10))
END
GO

EXEC UCLN 10 , 15




-- IF OBJECT_ID('') IS NOT NULL DROP PROC
-- GO
-- CREATE PROCEDURE 

-- AS
-- BEGIN

-- END
-- GO
-- EXEC 


-- Bài 2: (3 điểm)
-- Sử dụng cơ sở dữ liệu QLDA, Viết các Proc:
-- ➢ Nhập vào @Manv, xuất thông tin các nhân viên theo @Manv.
IF OBJECT_ID('TTNV') IS NOT NULL DROP PROC TTNV
GO
CREATE PROCEDURE TTNV
    @ma NVARCHAR(9)
AS
BEGIN
    SELECT *
    FROM NHANVIEN
    WHERE MANV LIKE @ma
END
GO
EXEC TTNV N'001'

-- ➢ Nhập vào @MaDa (mã đề án), cho biết số lượng nhân viên tham gia đề án đó
IF OBJECT_ID('TTDA') IS NOT NULL DROP PROC TTDA
GO
CREATE PROCEDURE  TTDA
    @ma int
AS
BEGIN
    SELECT PHANCONG.MADA, TENDEAN, COUNT(PHANCONG.MA_NVIEN) AS SLNV
    FROM PHANCONG JOIN DEAN ON PHANCONG.MADA = DEAN.MADA
    WHERE PHANCONG.MADA = @ma
    GROUP BY PHANCONG.MADA, TENDEAN
END
GO
EXEC TTDA  1

-- ➢ Nhập vào @MaDa và @Ddiem_DA (địa điểm đề án), cho biết số lượng nhân viên tham
-- gia đề án có mã đề án là @MaDa và địa điểm đề án là @Ddiem_DA
IF OBJECT_ID('TTDA1') IS NOT NULL DROP PROC TTDA1
GO
CREATE PROCEDURE  TTDA1
    @ma int,
    @dd NVARCHAR(15)
AS
BEGIN
    IF EXISTS 
    (
        SELECT *
    FROM DEAN
    WHERE MADA = @ma AND DDIEM_DA LIKE CAST(@dd AS NVARCHAR(15))
    )   
    BEGIN
        SELECT DEAN.MADA, TENDEAN, COUNT(PHANCONG.MA_NVIEN) AS SLNV
        FROM DEAN LEFT JOIN PHANCONG ON PHANCONG.MADA = DEAN.MADA
        WHERE DEAN.MADA = @ma
        GROUP BY DEAN.MADA, TENDEAN
    END
    ELSE
        PRINT N'KHÔNG CÓ ĐỀ ÁN VỚI MÃ: ' + CAST(@ma AS NVARCHAR(5)) + N' Ở ' + @dd
END
GO
EXEC TTDA1  11, N'Hà Nội'
EXEC TTDA1  10, N'Hà Nội'
EXEC TTDA1  21, N'Hà Nội'

-- ➢ Nhập vào @Trphg (mã trưởng phòng), xuất thông tin các nhân viên có trưởng phòng là
-- @Trphg và các nhân viên này không có thân nhân.
IF OBJECT_ID('TTNV2') IS NOT NULL DROP PROC TTNV2
GO
CREATE PROCEDURE TTNV2
    @ma int
AS
BEGIN
    SELECT *
    FROM NHANVIEN
    WHERE PHG IN
    (
        SELECT MAPHG
        FROM PHONGBAN
        WHERE TRPHG = @ma
    )
        AND NOT EXISTS 
    (
        SELECT *
        FROM THANNHAN
        WHERE THANNHAN.MA_NVIEN = NHANVIEN.MANV
    )
END
GO
EXEC TTNV2 '005'
go
-- SELECT *
-- FROM NHANVIEN
-- SELECT *
-- FROM PHONGBAN
-- SELECT *
-- from THANNHAN

-- ➢ Nhập vào @Manv và @Mapb, kiểm tra nhân viên có mã @Manv có thuộc phòng ban có
-- mã @Mapb hay không
IF OBJECT_ID('KTNVPB') IS NOT NULL DROP PROC KTNVPB
GO
CREATE PROCEDURE KTNVPB
    @manv NVARCHAR(9),
    @mapb int
AS
BEGIN
    IF EXISTS 
    (
        SELECT *
    FROM NHANVIEN
    WHERE MANV = @manv AND PHG = @mapb
    )
    PRINT N'Nhân viên có mã: ' + @manv + N' thuộc phòng ban mã: ' + CAST(@mapb AS NVARCHAR(9))
    ELSE
    PRINT N'Nhân viên có mã: ' + @manv + N' không thuộc phòng ban mã: ' + CAST(@mapb AS NVARCHAR(9))
END
GO
EXEC KTNVPB '005',5
EXEC KTNVPB '006',5




-- Bài 3: (3 điểm)

-- Sử dụng cơ sở dữ liệu QLDA, Viết các Proc
-- ➢ Thêm phòng ban có tên CNTT vào csdl QLDA, các giá trị được thêm vào dưới dạng
-- tham số đầu vào, kiếm tra nếu trùng Maphg thì thông báo thêm thất bại.
IF OBJECT_ID('ADDTABLETOQLDA') IS NOT NULL DROP PROC ADDTABLETOQLDA
GO
CREATE PROCEDURE ADDTABLETOQLDA
    @ten NVARCHAR(15) = null,
    @ma int = null,
    @trphg NVARCHAR(9) = null,
    @ngay DATE = null
AS
BEGIN
    BEGIN TRY
        IF @ten IS NULL
        PRINT N'Không được để trống tên phòng ban'
        ELSE IF @ma IS NULL
        PRINT N'Không được để trống mã phòng ban'
        ELSE IF @ngay IS NULL
        PRINT N'Không được để trống ngàt nhận chức'
        ELSE IF EXISTS 
            (
                SELECT * FROM PHONGBAN WHERE MAPHG = @ma
            )
        PRINT N'Đã có mã phòng ban này'
        ELSE
        BEGIN
            IF @trphg IS NOT NULL
                INSERT [dbo].[PHONGBAN]
                ([TENPHG], [MAPHG], [TRPHG], [NG_NHANCHUC])
                VALUES (@ten, @ma, @trphg, @ngay)
            ELSE
                INSERT [dbo].[PHONGBAN]
                ([TENPHG], [MAPHG], [TRPHG], [NG_NHANCHUC])
                VALUES (@ten, @ma, null, @ngay)
            PRINT N'Thêm Vào Thành Công'
        END
    END TRY
    BEGIN CATCH
        DECLARE @errmes NVARCHAR(2048) = ERROR_MESSAGE(),
        @errnum INT = ERROR_NUMBER()
        PRINT N'Lỗi xảy ra: ' + CAST(@errnum AS NVARCHAR(10)) + ' ' + @errmes
    END CATCH
END
GO
DECLARE @indate DATE = CAST(N'1971-06-19' AS Date)
EXEC ADDTABLETOQLDA    N'CNTT', 50, N'006', @indate

-- ➢ Cập nhật phòng ban có tên CNTT thành phòng IT.
IF OBJECT_ID('RENPHG') IS NOT NULL DROP PROC RENPHG
GO
CREATE PROCEDURE RENPHG
@befor NVARCHAR(15),
@after NVARCHAR(15)
AS
BEGIN
    IF EXISTS 
        (
            SELECT * FROM PHONGBAN WHERE TENPHG LIKE @befor
        )
        UPDATE PHONGBAN
        SET TENPHG = @after
        WHERE TENPHG LIKE @befor
    ELSE
        PRINT N'Lỗi Xảy Ra. Không có phòng ban ' + @befor
END
GO
EXEC RENPHG 'CNTT', 'IT'

-- ➢ Thêm một nhân viên vào bảng NhanVien, tất cả giá trị đều truyền dưới dạng tham số đầu
-- vào với điều kiện:
-- o nhân viên này trực thuộc phòng IT
-- o Nhận @luong làm tham số đầu vào cho cột Luong, nếu @luong<25000 thì nhân
-- viên này do nhân viên có mã 009 quản lý, ngươc lại do nhân viên có mã 005 quản
-- lý
-- o Nếu là nhân viên nam thi nhân viên phải nằm trong độ tuổi 18-65, nếu là nhân
-- viên nữ thì độ tuổi phải từ 18-60.
IF OBJECT_ID('ADDTONV') IS NOT NULL DROP PROC ADDTONV
GO
CREATE PROCEDURE ADDTONV
    @ho NVARCHAR(15),
    @lot NVARCHAR(15),
    @ten  NVARCHAR(15),
    @ma NVARCHAR(9),
    @ngsinh DateTime,
    @dchi NVARCHAR(30),
    @gt NVARCHAR(3),
    @luong float
AS
BEGIN
    DECLARE @nql NVARCHAR(9), @phg INT
    SELECT @phg = MAPHG
    FROM PHONGBAN
    WHERE TENPHG LIKE 'IT'
    IF @luong <25000
        SET @nql = '009'
    ELSE
        SET @nql = '005'
    IF EXISTS 
        (
            SELECT *
            FROM NHANVIEN
            WHERE MANV = @ma
        )
        PRINT N'Đã có mã nhân viên này'
    ELSE IF @gt LIKE 'Nam' 
        BEGIN
        IF DATEDIFF(YEAR,@ngsinh,GETDATE())  <18 OR DATEDIFF(YEAR,@ngsinh,GETDATE()) > 65
        PRINT N'Nhân viên nam tuổi phải từ 18-65'
        ELSE
        INSERT [dbo].[NHANVIEN] ([HONV], [TENLOT], [TENNV], [MANV], [NGSINH], [DCHI], [PHAI], [LUONG], [MA_NQL], [PHG])
        VALUES (@ho, @lot, @ten, @ma, @ngsinh, @dchi, @gt, @luong, @nql, @phg)
        END
    ELSE
        BEGIN
        IF DATEDIFF(YEAR,@ngsinh,GETDATE())  <18 OR DATEDIFF(YEAR,@ngsinh,GETDATE()) > 60
        PRINT N'Nhân viên nữ tuổi phải từ 18-60'
        ELSE
        INSERT [dbo].[NHANVIEN] ([HONV], [TENLOT], [TENNV], [MANV], [NGSINH], [DCHI], [PHAI], [LUONG], [MA_NQL], [PHG])
        VALUES (@ho, @lot, @ten, @ma, @ngsinh, @dchi, @gt, @luong, @nql, @phg)
        END
    
END
GO
DECLARE @indate DateTime = CAST(N'1962-08-20T00:00:00.000' AS DateTime)
EXEC ADDTONV  N'Nguễn', N'Thanh', N'Tùng', N'030', @indate, N'222 Nguyễn Văn Cừ, Tp HCM', N'Nam', 40000