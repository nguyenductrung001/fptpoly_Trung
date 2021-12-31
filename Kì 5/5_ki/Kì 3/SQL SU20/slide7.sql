--slide 7: hàm do người dùng định nghĩa
--I hàm do ng dùng định nghĩa
--❑Tương tự như Stored Procedure
 --❖Là một đối tượng CSDL chứa các câu lệnh SQL, được biên dịch sẵn và lưu trữ trong CSDL.
  --❑Khác với Stored Procedure 
  --➢Các hàm luôn phải trả về một giá trị, sử dụng câu lệnh RETURN 
  --➢Hàm không có tham số đầu ra 
  --➢Không được chứa các câu lệnh INSERT, UPDATE, DELETE một bảng hoặc view đang tồn tại trong CSDL 
  --➢Có thể tạo bảng, bảng tạm, biến bảng và thực hiện các câu lệnh INSERT, UPDATE, DELETE trên các bảng, bảng tạm, biến bảng vừa tạo trong thân hàm
  --1. tạo hàm Gía trị  vô hướng 
  -- cú pháp 
  create function ten_ham(@TS1_neu_co kieuDL= giatriMacDinh_neuco,
						  @TS2_neu_co kieuDL= giatriMacDinh_neuco,
						  ............
						)
	Return kieu_DL_vohuong
	as
	Begin
		-- các lệnh
		Return gia_tri_vohuong
	End
-- Lưu ý:
--Không thể truyền tham số theo tên
 --❑Truyền đầy đủ các tham số theo vị trí.
 --Kể cả tham số tùy chọn, nếu muốn sử dụng giá trị mặc định, 
 --phải đặt từ khóa DEFAULT tại đúng vị trí tham số tùy chọn đó.
 --VD1:Xây dựng hàm tính tuổi đầu vào là năm sinh 
 if OBJECT_ID('fn_Age') is not null
     drop function fn_Age
 go
 create function fn_Age (@NamSinh int=1990)
 returns int
 As
 Begin
	return(year(getDate())-@NamSinh)
 end
 --Gọi hàm 
 print N'tuổi' + cast (dbo.fn_Age(2000)as nvarchar)
 print N'tuổi' + cast (dbo.fn_Age(Default) as nvarchar) -- dùng mặc định

 --C2:
 Declare @kq int
 select @kq = dbo.fn_Age(2000)
 select @kq
--VD2: Xây dựng hàm trả về tổng số lượng nhân viên 
use	QLDA
go
if OBJECT_ID('fn_TongNV') is not null
     drop function fn_TongNV
 go
 create function fn_TongNV ()
 returns int
 As
 Begin
	return(select count(*) from NHANVIEN)
 end
 -- gọi thủ tục:
 print N'Tổng NV là:' +cast (dbo.fn_TongNV() as nvarchar)
 --C2:
 declare @kq int 
 select @kq = dbo.fn_TongNV()
 select @kq
 ------------------------------
 --2.Hàm giá trị bảng đơn giản 
 create function ten_ham(@TS1_neu_co kieuDL= giatriMacDinh_neuco,
						  @TS2_neu_co kieuDL= giatriMacDinh_neuco,
						  .....
						)
	Returns Table
	as
	
		
		Return (câu lệnh select)
--VD1: tạo hàm đầu vào và MaPhong.Hàm trả về thông tin nhân viên của phòng truyền vào
-- thông tin:maNV,Hoten,phai
select *
from NHANVIEN
if OBJECT_ID('fn_ThongTinNV') is not null
	drop function fn_ThongTinNV
go
Create function fn_ThongTinNV (@MaPhong int = 1)
	Returns table
As 
	Return(select MANV,HONV +' '+ TENLOT+' '+ TENNV as hoten ,PHAI from NHANVIEN where PHG = @MaPhong)
	--gọi hàm 
	select* from fn_ThongTinNV(4)
	select * from fn_ThongTinNV(default)
-----------------------------------------------------------------
--3.Bảng đa câu lệnh 
create function ten_ham(@TS1_neu_co kieuDL= giatriMacDinh_neuco,
						  @TS2_neu_co kieuDL= giatriMacDinh_neuco,
						  .....
						)
	Returns @Ten_Bang Table
				(-- giống tạo bảng
					tencot1 kieuDL,
					tencot2 kieuDL,
					--------------
				)
	as
	Begin
	-- các lệnh.Nên có lệnh đổ dữ liệu vào @BienBang
		Return 
	End
	--VD1: Làm lại VD trên, dùng hàm giá trị bảng đa câu lệnh 
if OBJECT_ID('fn_ThongTinNV1') is not null
	drop function fn_ThongTinNV1
go
Create function fn_ThongTinNV1 (@MaPhong int = 1)
	Returns @Ten table (
			MaNV nvarchar(9),
			TenNV nvarchar(47),
			Phai nvarchar(3)
	)
As 
Begin
insert into @Ten
select MANV,HONV +' '+ TENLOT+' '+ TENNV  ,PHAI from NHANVIEN where PHG = @MaPhong
return
end
--gọi hàm 
select *
from dbo.fn_ThongTinNV1(default)
------------------------------------------PhầnII: view-------------------
	--cú pháp:
	create view Vw_Ten_view
	as
			câu lệnh select

--gọi
select * Vw_Ten_view
--Lưu ý :+ Không chứa Mệnh đề into hoặc orderby trừ khi chứa từ khóa TOP
	    --+ Cột chứa giá trị được tính toán từ nhiều cột khác phải được đặt tên
--VD1: tạo view chứa thông tin các nhân viên Nam 
use QLDA
go
if OBJECT_ID('Vw_NVnam') is not null
drop view Vw_NVnam
go
create view Vw_NVnam

as
select*from  NHANVIEN
where PHAI like N'Nữ'
-- gọi hàm
select* from Vw_NVnam

---VIEW CÓ THỂ CẬP NHẬt
--❖Mệnh đề DISTINCT hoặc TOP 
--❖Một hàm kết tập (Aggregate function) 
--❖Một giá trị được tính toán 
--❖Mệnh đề GROUP BY và HAVING 
--❖Toán tử UNION 
--❖Nếu câu lệnh tạo View vi phạm một trong số điều kiện trên. VIEW được tạo ra là VIEW chỉ đọc

		
		
	

