use master
go
drop database QLPT2
go
create database QLPT2
go
--sử dụng csdl
use QLPT2
go

create table LN( 
  Maloainha  nvarchar(10)  not null,
  Tenloainha nvarchar(50) not null,
  constraint PK_loainha primary key (Maloainha),
)
go

create table QUAN
(
MaQuan nvarchar(10) not null,
TenQuan nvarchar(100) not null,
constraint PK_QUAN primary key (MaQuan),
)
go

create table NGUOIDUNG(
    MaNguoiDung nvarchar(10) not null,
    TenND nvarchar(30) not null,
	Gioitinh nvarchar(5) not null,
	SoDT nvarchar(20) not null,
	Diachi nvarchar(100) not null,
	MaQuan nvarchar(10) not null,
	Email nvarchar(100) not null,
	constraint PK_TenND primary key(MaNguoiDung),
	constraint FK_NGUOIDUNG_QUAN foreign key(MaQuan) references Quan(MaQuan)
) 
go
create table NHATRO(
	 Manhatro  nvarchar(10)  not null,
     Maloainha  nvarchar(10)  not null,
	 Dientich int not null,
	 Gia nvarchar(20) not null,
	 Diachi nvarchar(100) not null,
	 MaQuan nvarchar(10) not null,
	 mota nvarchar(500) not null,
	 ngaydang datetime not null,
	 NGUOIDUNG nvarchar(10) not null,
	 constraint PK_NHATRO primary key (Manhatro),
	 constraint FK_NHATRO_QUAN foreign key (MaQuan) references QUAN(MaQuan),
	 constraint FK_NHATRO_LN foreign key (Maloainha) references LN(Maloainha),
	 constraint FK_NHATRO_NGUOIDUNG foreign key (NGUOIDUNG) references NGUOIDUNG(MaNguoiDung),
)
go
 


create table NDNHATRO
(
	MaND nvarchar(10) not null,
	Manhatro  nvarchar(10)  not null,
	NgayDen datetime not null,
	NgayDi datetime not null,
	constraint PK_NDNHATRO primary key(MaND,Manhatro),
	constraint FK_NDNHATRO_NGUOIDUNG foreign key (MaND) references NGUOIDUNG(MaNguoiDung),
	constraint FK_NDNHATRO_NHATRO foreign key (Manhatro) references NHATRO(Manhatro),
)
go

create table DANHGIA(
   MaDanhGia nvarchar(10) not null,
   MaNguoiDung nvarchar(10) not null,
   Manhatro  nvarchar(10)  not null,
   TenND nvarchar(30) not null,
   likeornot bit not null,
   NDDANHGIA nvarchar(500) not null,
   constraint PK_DANHGIA primary key(MaDanhGia), 
   constraint FK_DANHGIA_NDNHATRO foreign key (MaNguoiDung,Manhatro) references NDNHATRO(MaND,Manhatro),
)
go
--Nhập liệu
--bảng1
insert into LN(Maloainha,Tenloainha)
values('LN01',N'Nha Tro'),
       ('LN02',N'Trung cư'),
	   ('LN03',N'Trung cư mini'),
	   ('LN04',N'Khách sạn'),
	   ('LN05',N'Nhà nghỉ')
go
--Bảng 2
insert into QUAN(MaQuan,TenQuan)
values ('Q01',N'Hoàn Kiếm'),
       ('Q02',N'Hai Bà Trưng'),
       ('Q03',N'Thanh Xuân'),
       ('Q04',N'Ba Đình'),
       ('Q05',N'Đống Đa')
go
--Bảng 3
insert into NGUOIDUNG(MaNguoiDung,TenND ,Gioitinh,SoDT ,Diachi,MaQuan,Email)
values ('ND001',N'Nguyen Van A',N'Nam',0987654321,N'Thanh Xuân','Q03',N'ANVPH0000@gmail.com'),
       ('ND002',N'Nguyen Van B',N'NỮ',0946444666,N'Hoàn Kiếm','Q01',N'BNVPH0000@gmail.com'),
       ('ND003',N'Nguyen Van C',N'NỮ',0987666555,N'Ba Đình','Q04',N'CNVPH0000@gmail.com'),
       ('ND004',N'Nguyen Van D',N'Nam',0322777888,N'Đống Đa','Q05',N'DNVPH0000@gmail.com'),
       ('ND005',N'Nguyen Van E',N'NỮ',0362999999,N'Hai Bà Trưng','Q02',N'ENVPH0000@gmail.com'),
       ('ND006',N'Nguyen Van F',N'Nam',0123456789,N'Thanh Xuân','Q03',N'FNVPH0000@gmail.com'),
       ('ND007',N'Nguyen Van G',N'Nam',0988999666,N'Đống Đa','Q05',N'GNVPH0000@gmail.com'),
       ('ND008',N'Nguyen Van H',N'NỮ',03222111111,N'Ba Đình','Q04',N'HNVPH0000@gmail.com'),
       ('ND009',N'Nguyen Van J',N'Nam',09999000999,N'Thanh Xuân','Q03',N'JNVPH0000@gmail.com'),
       ('ND010',N'Nguyen Van K',N'Nam',0987654321,N'Thanh Xuân','Q01',N'ANVPH0000@gmail.com')
	   go

-- bảng4
insert into NHATRO(Manhatro,Maloainha, Dientich,Gia,Diachi, MaQuan, mota, ngaydang, NGUOIDUNG)
values ('NT01','LN01',20,4000000,N'Hà Nội',N'Q01',N'Khép kín',2020/06/07,'ND001'),
		('NT02','LN02',30,4000000,N'Hà Nội',N'Q03',N'Không Khép kín',2020/07/07,'ND002'),
		('NT03','LN03',40,4000000,N'Hà Nội',N'Q05',N'Khép kín',2020/08/07,'ND003'),
		('NT04','LN04',50,4000000,N'Hà Nội',N'Q04',N'Khép kín',2020/09/07,'ND004'),
		('NT05','LN05',60,4000000,N'Hà Nội',N'Q02',N'Không Khép kín',2020/06/08,'ND005'),
		('NT06','LN04',70,4000000,N'Hà Nội',N'Q05',N'Khép kín',2020/06/07,'ND006'),
		('NT07','LN05',80,4000000,N'Hà Nội',N'Q01',N'Không Khép kín',2020/06/09,'ND007'),
		('NT08','LN02',60,4000000,N'Hà Nội',N'Q02',N' không Khép kín',2020/09/07,'ND008'),
		('NT09','LN02',50,4000000,N'Hà Nội',N'Q04',N'Khép kín',2020/05/07,'ND009'),
		('NT10','LN03',30,4000000,N'Hà Nội',N'Q01',N'Khép kín',2020/06/07,'ND001')
		go
--Bảng 5
insert into NDNHATRO(MaND,Manhatro,NgayDen,NgayDi)
values ('ND001','NT01',2020/02/04,2020/03/05),
       ('ND002','NT02',2020/02/03,2020/02/05),
	   ('ND006','NT03',2020/02/07,2020/02/14),
	   ('ND009','NT04',2020/02/04,2020/06/02),
	   ('ND007','NT05',2020/02/09,2020/02/18)
	   go
	   select *
	   from NDNHATRO
--bảng 6
insert into DANHGIA( MaDanhGia,MaNguoiDung,Manhatro,TenND,NDDANHGIA,likeornot)
values ('DG01','ND001','NT01',N'Nguyen Van A',N'TỐT',0),
		('DG02','ND002','NT02',N'Nguyen Van B',N'Kém',1),
		('DG03','ND006','NT03',N'Nguyen Van G',N'Bình thường',0),
		('DG04','ND009','NT04',N'Nguyen Van J',N'TỐT',1),
		('DG05','ND007','NT05',N'Nguyen Van G',N'Kém',0)
go
select *
from DANHGIA
----------------------------
--1. Thêm thông tin vào các bảng 

--SP thứ nhất thực hiện chèn dữ liệu vào bảng NGUOIDUNG 

if OBJECT_ID('sp_addngdung') is not NULL
DROP PROC sp_addngdung
go


CREATE PROC sp_addngdung
     @MaNguoiDung nvarchar(10) = null,
    @TenND nvarchar(30) = null,
	@Gioitinh nvarchar(5) = null,
	@SoDT nvarchar(20) = null,
	@Diachi nvarchar(100) = null,
	@MaQuan nvarchar(10) = null,
	@Email nvarchar(100) = null
AS
BEGIN
BEGIN TRY
      IF ( @MaNguoiDung = null)
          or ( @TenND = null)
          or ( @Gioitinh = null)
          or ( @SoDT = null)
          or ( @Diachi = null)
          or ( @MaQuan = null)
		  or ( @Email = null)
          PRINT N'Vui lòng nhập email'
-- ELSE IF not exists (select * from NGUOIDUNG WHERE maNguoiDung = @maNguoiDung)
-- PRINT N'Lỗi khóa chính, Đã có mã đề án'
ELSE IF not exists (select * from QUAN WHERE MaQuan = @MaQuan)
PRINT N'Lỗi khóa ngoại, không tồn tại quận'

ELSE
    BEGIN 
       INSERT into NGUOIDUNG(MaNguoiDung,TenND,Gioitinh,SoDT,Diachi,MaQuan,Email)
        VALUEs(
    @MaNguoiDung ,
    @TenND ,
	@Gioitinh ,
	@SoDT ,
	@Diachi,
	@MaQuan ,
	@Email 
        )
        PRINT N'Thêm thành công'
END
END TRY
BEGIN CATCH
DECLARE @in NVARCHAR = Error_message()
    print N'Xảy ra lỗi'  + CAST(Error_message() as nvarchar)
END CATCH

END
exec sp_addngdung 'ND021',N'Nguyen Van A',N'Nam','0987654321',N'Thanh Xuân','Q03',N'ANVPH0000@gmail.com'
select* from NGUOIDUNG

-- SP thứ hai thực hiện chèn dữ liệu vào bảng NHATRO 

if OBJECT_ID('sp_addnhatro') is not NULL
DROP PROC sp_addnhatro
go


CREATE PROC sp_addnhatro
   @Manhatro  nvarchar(10)  = null,
    @Maloainha  nvarchar(10)  = null,
	@Dientich int = null,
	 @Gia nvarchar(20) = null,
	 @Diachi nvarchar(100) = null,
	 @MaQuan nvarchar(10) = null,
	 @mota nvarchar(500) = null,
	 @ngaydang datetime = null,
	 @NGUOIDUNG nvarchar(10) = null


AS
BEGIN
BEGIN TRY
      IF ( @Manhatro = null)
         or ( @Maloainha = null)
          or ( @Dientich = null)
          or ( @Gia = null)
          or ( @Diachi = null)
          or ( @MaQuan = null)
          or ( @mota = null)
		  or ( @ngaydang = null)
          or ( @NGUOIDUNG = null)
          PRINT N'Vui lòng nhập đủ các trường!'
-- ELSE IF not exists (select * from NGUOIDUNG WHERE maNguoiDung = @maNguoiDung)
-- PRINT N'Lỗi khóa chính, Đã có mã đề án'
ELSE IF not exists (select * from LN WHERE Maloainha like @Maloainha)
PRINT N'Lỗi khóa ngoại, không tồn tại loại nhà'
ELSE IF not exists (select * from QUAN WHERE MaQuan = @MaQuan)
PRINT N'Lỗi khóa ngoại, không tồn tại quận'
ELSE IF not exists (select * from NGUOIDUNG WHERE MaNguoiDung = @NGUOIDUNG)
PRINT N'Lỗi khóa ngoại, không tồn tại chủ nhà '
ELSE
    BEGIN 
       INSERT into NHATRO(Manhatro,Maloainha,Dientich,Gia,Diachi,MaQuan,mota,ngaydang,NGUOIDUNG)
        VALUEs(
    @Manhatro  ,
    @Maloainha ,
	@Dientich ,
	 @Gia ,
	 @Diachi ,
	 @MaQuan ,
	 @mota ,
	  @ngaydang ,
	 @NGUOIDUNG
        )
        PRINT N'Thêm thành công'
END
END TRY
BEGIN CATCH
DECLARE @in NVARCHAR = Error_message()
    print N'Xảy ra lỗi'  + CAST(Error_message() as nvarchar)
END CATCH

END
exec sp_addnhatro 'NT011','LN01',20,4000000,N'Hà Nội',N'Q01',N'Khép kín','2020-06-07','ND001'
select* from NHATRO
--SP thứ ba thực hiện chèn dữ liệu vào bảng DANHGIA

if OBJECT_ID('sp_adddanhgia') is not NULL
DROP PROC sp_adddanhgia
go


CREATE PROC sp_adddanhgia
   @MaDanhGia nvarchar(10) = null,
   @MaNguoiDung nvarchar(10) = null,
   @Manhatro  nvarchar(10)  = null,
   @TenND nvarchar(30) = null,
   @likeornot bit = null,
   @NDDANHGIA nvarchar(500) = null
    as
BEGIN
BEGIN TRY
      IF ( @MaDanhGia = null ) 
	  or (@MaNguoiDung = null)
	  or (@Manhatro = null)
	  or(@TenND = null)
		or(@likeornot = null)
		or(@NDDANHGIA= NULL)
          PRINT N'Vui lòng nhập đủ các trường'
-- ELSE IF not exists (select * from NGUOIDUNG WHERE maNguoiDung = @maNguoiDung)
-- PRINT N'Lỗi khóa chính, Đã có mã đề án'
ELSE IF not exists (select * from NDNHATRO WHERE MaND  = @MaNguoiDung and Manhatro = @Manhatro)
PRINT N'Người dùng không ở nhà trọ này.Đéo được đánh giá!'

ELSE
    BEGIN 
       INSERT into DANHGIA (MaDanhGia,MaNguoiDung,Manhatro,TenND,likeornot,NDDANHGIA)
        VALUEs(
     @MaDanhGia,
   @MaNguoiDung, 
   @Manhatro , 
   @TenND, 
   @likeornot ,
   @NDDANHGIA 
        )
        PRINT N'Thêm thành công'
END
END TRY
BEGIN CATCH
DECLARE @in NVARCHAR = Error_message()
    print N'Xảy ra lỗi'  + CAST(Error_message() as nvarchar)
END CATCH

END
exec sp_adddanhgia 'DG09','ND001','NT01',N'Nguyen Van A',0,N'Tốt'

--e. Viết một Stored Procedure nhận tham số đầu vào là mã nhà trọ (cột khóa chính của
--bảng NHATRO). SP này trả về tập kết quả gồm các thông tin sau:
-- Mã nhà trọ
-- Tên người đánh giá
-- Trạng thái LIKE hay DISLIKE
-- Nội dung đánh giá
if OBJECT_ID('sp_thongTinLike') is not null 
  drop proc sp_thongTinLike
go
create proc sp_thongTinLike
	@maNhaTro nvarchar(10) = '%'
As
Begin
	select NDNHATRO.Manhatro,DANHGIA.TenND as nguoiDanhGia,NDDANHGIA
from NGUOIDUNG inner join NDNHATRO on NGUOIDUNG.MaNguoiDung = NDNHATRO.MaND
				inner join DANHGIA on DANHGIA.MaNguoiDung = NDNHATRO.MaND and DANHGIA.Manhatro = NDNHATRO.Manhatro
end
go

	alter table DANHGIA
	add likeornot bit

--3. Xóa thông tin
--1. Viết một SP nhận một tham số đầu vào kiểu int là số lượng DISLIKE. SP này thực hiện
--thao tác xóa thông tin của các nhà trọ và thông tin đánh giá của chúng, nếu tổng số lượng
--DISLIKE tương ứng với nhà trọ này lớn hơn giá trị tham số được truyền vào.
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác
--xóa thực hiện không thành công
if OBJECT_ID('sp_xoaNhaTro') is not null
	drop proc sp_xoaNhaTro
go

create proc sp_xoaNhaTro
	@numDisLike int
as
	BEGIN TRY
		begin tran
			if OBJECT_ID('temdb...#BangTAM') is not null -- nếu bảng tạm tồn tại thì xóa bảng tạm 
				drop table #BangTam
			-- B1 lấy thông tin MANHTro thỏa mãn điều kiện => bảng tạm 
			select Manhatro , count(likeornot) as soLuotKhongThik into #BangTam
			from DANHGIA
			Where likeornot = 0 
			group by Manhatro
			Having count (likeornot) >@numDisLike

			-- b2: Xóa Thông tin NDNHATRO có bảng tạm 
			delete from DANHGIA
			Where Manhatro in (select Manhatro from #BangTam)
			--b3
			delete from NDNHATRO
			Where Manhatro in (select Manhatro from #BangTam)
			--B4
			delete from NHATRO
			Where Manhatro in (select Manhatro from #BangTam)
			print 'Xóa thành công!'
	    COMMIT tran -- giao dịch hoàn thành 
	end Try
	Begin CATCH
		Print N'gặp lỗi:' + Error_Message()
		ROLLBACK tran -- hoantac
	END CATCH
	-- gọi thủ tục 
	exec sp_xoaNhaTro 0 

	--2. Viết một SP nhận hai tham số đầu vào là khoảng thời gian đăng tin. SP này thực hiện
--thao tác xóa thông tin những nhà trọ được đăng trong khoảng thời gian được truyền vào
--qua các tham số.
--Lưu ý: SP cũng phải thực hiện xóa thông tin đánh giá của các nhà trọ này.
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác
--xóa thực hiện không thành công.

if OBJECT_ID('sp_xoaNhaTroNgayDang') is not null
	drop proc sp_xoaNhaTroNgayDang
go

create proc sp_xoaNhaTroNgayDang
	@TuNgay datetime,
	@DenNgay datetime
as
	BEGIN TRY
		begin tran
			if OBJECT_ID('temdb...#BangTAM') is not null -- nếu bảng tạm tồn tại thì xóa bảng tạm 
				drop table #BangTam
			-- B1 lấy thông tin MANHTro thỏa mãn điều kiện => bảng tạm 
			select Manhatro into #BangTam
			from NHATRO
			Where ngaydang between @TuNgay and @DenNgay
			group by Manhatro
			

			-- b2: Xóa Thông tin NDNHATRO có bảng tạm 
			delete from DANHGIA
			Where Manhatro in (select Manhatro from #BangTam)

	    COMMIT tran -- giao dịch hoàn thành 
	end Try
	Begin CATCH
		Print N'gặp lỗi:' + Error_Message()
		ROLLBACK tran -- hoantac
	END CATCH

	-- goi thu tuc 
	exec sp_xoaNhaTroNgayDang '2015-12-15' , '2015-12-20'
	select* 
	from NHATRO

--2. Truy vấn thông tin
--a. Viết một SP với các tham số đầu vào phù hợp. SP thực hiện tìm kiếm thông tin các
--phòng trọ thỏa mãn điều kiện tìm kiếm theo: Quận, phạm vi diện tích, phạm vi ngày đăng
--tin, khoảng giá tiền, loại hình nhà trọ.
--SP này trả về thông tin các phòng trọ, gồm các cột có định dạng sau:
--o Cột thứ nhất: có định dạng ‘Cho thuê phòng trọ tại’ + <Địa chỉ phòng trọ>
--+ <Tên quận/Huyện>
--o Cột thứ hai: Hiển thị diện tích phòng trọ dưới định dạng số theo chuẩn Việt Nam +
--m2. Ví dụ 30,5 m2
--o Cột thứ ba: Hiển thị thông tin giá phòng dưới định dạng số theo định dạng chuẩn
--Việt Nam. Ví dụ 1.700.000
--o Cột thứ tư: Hiển thị thông tin mô tả của phòng trọ
--o Cột thứ năm: Hiển thị ngày đăng tin dưới định dạng chuẩn Việt Nam.
--Ví dụ: 27-02-2012
--o Cột thứ sáu: Hiển thị thông tin người liên hệ dưới định dạng sau:
--▪ Nếu giới tính là Nam. Hiển thị: A. + tên người liên hệ. Ví dụ A. Thắng
--▪ Nếu giới tính là Nữ. Hiển thị: C. + tên người liên hệ. Ví dụ C. Lan
--o Cột thứ bảy: Số điện thoại liên hệ
--o Cột thứ tám: Địa chỉ người liên hệ
-- Viết hai lời gọi cho SP này
if OBJECT_ID('sp_TimKiem') is not null
drop proc sp_TimKiem
go

create proc sp_TimKiem
@TenQuan nvarchar(50) = '%',
@MinDienTich decimal(7,3) = 0,
@MaxDienTich decimal(7,3) = 100,
@MinNgayDang datetime = '1900-01-01',
@MaxngayDang datetime = null,
@MinGiaTien money = 0,
@MaxGiaTien money = 10000000,
@loaiNha nvarchar(50) = '%'
as
Begin
	if(@MaxngayDang is null)
	set @MaxngayDang = getdate() 
	select TenQuan,
		   Dientich,
		   Gia,
		   mota,
		   CONVERT(nvarchar,ngaydang,105) as NgayDangTin,
		   iif(Gioitinh=N'NAM','A.','C. ')+ TenND as chuNha,
		   NGUOIDUNG.SoDT,
		   NGUOIDUNG.Diachi
	from LN inner join NHATRO on LN.Maloainha = NHATRO.Maloainha
			inner join NGUOIDUNG on NGUOIDUNG.MaNguoiDung = NHATRO.NGUOIDUNG
			inner join QUAN on NHATRO.MaQuan = QUAN.MaQuan
	Where TenQuan like @TenQuan
		and (Dientich between @MinDienTich and @MaxDienTich)
		and(ngaydang between @MinNgayDang and @MaxngayDang)
		and(Gia between @MinGiaTien and @MaxGiaTien)
		and Tenloainha like @loaiNha
End
--GỌI THỦ TỤC 
exec sp_TimKiem 

-- b. Viết một hàm có các tham số đầu vào tương ứng với tất cả các cột của bảng
-- NGUOIDUNG. Hàm này trả về mã người dùng (giá trị của cột khóa chính của bảng
-- NGUOIDUNG) thỏa mãn các giá trị được truyền vào tham số.
	if OBJECT_ID('fn_timKiem') is not null
	 drop function fn_timKiem
	go
	create function fn_timKiem
	(
	@ten NVARCHAR(32)=N'%',
    @gioiTinh NVARCHAR(5)=N'%',
    @dienThoai NVARCHAR(15)=N'%',
    @diaChi NVARCHAR(55)=N'%',
    @quan INT = NULL,
    @email NVARCHAR(30) = N'%'
	)
	returns table
	As
	Return 
	select MaNguoiDung from NGUOIDUNG where TenND like @ten and
												Gioitinh like @gioiTinh
												AND SoDT like @dienThoai
												and Diachi like @diaChi
												--and MaQuan like @quan
												and Email like @email
												AND 1 = (   CASE
												WHEN @quan IS NULL THEN  1
												WHEN @quan = MaQuan THEN 1
												ELSE 0
												END)
    go
	SELECT *
FROM dbo.fn_timKiem(DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT)
--c. Viết một hàm có tham số đầu vào là mã nhà trọ (cột khóa chính của bảng
--NHATRO). Hàm này trả về tổng số LIKE và DISLIKE của nhà trọ này
			
	if OBJECT_ID('fn_countLike') is not null
		drop function fn_countLike
	go
	create function fn_countLike
	(
		@Mant nvarchar(10) = '%'
	)
	Returns @table 
	  table(
		LIKES int,
		DISLIKES int
	  )
	As
	Begin
		declare @LIKES int =0, @DISLIKES int = 0
		select @LIKES = count(likeornot)
		from DANHGIA
		where likeornot=1


		
		select @DISLIKES = count(likeornot)
		from DANHGIA
		where likeornot=0

		insert into @table
		values (@LIKES,@DISLIKES);

		
			
			return
	end
	go
	select * from fn_countLike(default)
	select* from DANHGIA
	--d. Tạo một View lưu thông tin của TOP 10 nhà trọ có số người dùng LIKE nhiều nhất gồm
        --các thông tin sau:
        -- Diện tích
		-- Giá
		-- Mô tả
		-- Ngày đăng tin
		-- Tên người liên hệ
		-- Địa chỉ
		--Điện thoại
		-- Email


		select* from NHATRO
-- nối 4 bảng ND, NDNHATRO,NHATRO,DANH GIÁ
if OBJECT_ID('top10NT_like') is not null
 drop view top10NT_like
 go
 Create view top10NT_like
 as
select top 10 Dientich,Gia,mota,ngaydang,NGUOIDUNG.TenND as chunha, NGUOIDUNG.Diachi,SoDT,Email
from NHATRO inner join NGUOIDUNG on NHATRO.NGUOIDUNG = NGUOIDUNG.MaNguoiDung
			inner join NDNHATRO on NHATRO.Manhatro = NDNHATRO.Manhatro
			inner join DANHGIA on NDNHATRO.MaND = DANHGIA.MaNguoiDung and NDNHATRO.Manhatro = DANHGIA.Manhatro 
where likeornot=1
group by Dientich,Gia,mota,ngaydang,NGUOIDUNG.TenND, NGUOIDUNG.Diachi,SoDT,Email
order by count(likeornot) desc
go
-- xel DL
select * from top10NT_like



































