use QLDA
GO
--slide4 Điều kiện vòng lặp 
--1. các xử lý điều kiện 
--a if....else
--if(Dieukien)
		--begin
			--các lệnh
		--end
--else 
		--begin 
			--các lệnh
		--end
-- chú ý : nếu thực thi hai hoặc nhiều câu lệnh trong mệnh  đề if...else. bạn cần bao các câu lệnh này trong khối Begin...End
declare @diem float =10
if(@diem <5)
print 'xếp loại yếu'
else if(@diem <7)
print 'khá'
else if(@diem <9)
print N'giỏi'
else
begin 
	print N'xuất sắc'
	print N'chúc mừng bạn'
end
  -- vd2 tính lương trung bình , nếu lương TB>25000 thì TB thu nhập tốt còn lại thu nhập không tốt 
	declare @LuongTB float 
  select @LuongTB =  AVG(LUONG)
   from NHANVIEN
  if(@LuongTB >25000)
  print 'thu nhập tốt'
  else
  print 'Cần tăng lương cho anh em'


--b If Exists: Nếu tồn tại 
--cú pháp :

if Exists(câu lệnh Select)
		begin
			--các lệnh
		end
else 
		begin 
			--các lệnh
		end

-- nếu có phòng điều hành  => đưa ra toàn bộ thoogn tin nhân viên phòng điều hành 
-- còn lại: TB không có nhân viên naog phòng điều hành 
if exists(select* from NHANVIEN  where PHG=4)
select *
from NHANVIEN
Where PHG = 4
else 
print'không có nhân viên nào '
  --c.cách sử dụng  IIF Function
  -- cú pháp:IIF (Điều kiện - giá trị đúng- giá trị sai)
  -- lấy thông tin nhân viên , hiển thị chức vụ :nếu lương >30000 là trưởng phòng 
  -- còn lại là nhân viên 
  select MANV,TENNV, LUONG,IIF (LUONG>30000,N'Trưởng Phòng',N'Nhân viên ') as chucvu
  from NHANVIEN
  group by MANV,TENNV, LUONG
  --2.case
  --a.SimPle Case (case đơn giản)
  case Biểu_thức
		When Gía_trị 1 then kết_quả_1 
		When Gía_trị 2 then kết_quả_2\
		else ket_qua_n 
  End
  --VD1: lấy thông tin  nhân viên : maNV , tenNV, phai
  --trong đó cột tên nhan viên hiển thị như sau :
  -- NẾU là nam :MR. + ten 
 -- Nếu là nữ: Mrs
 -- còn lại free sex

 select  MANV,
         case PHAI
			when N'Nam' then 'Mr.' + TENNV
			when N' Nữ' then 'Mrs.' + TENNV
			else 
			'free sex:' + TENNV
		 end as ten,
         PHAI
 from NHANVIEN

 --b. case search (cây tìm kiếm)
 Case
	when bieu_thuc_dieu_kien1 then kết_quả_1 
	when bieu_thuc_dieu_kien2 then kết_quả_2
	...
	when bieu_thuc_dieu_kien_n then kết_quả_n
	else 
	  Kết_quả_n
 end

 --VD1: giống VD trước nhưng dùng case search
select  MANV,
         case 
			when PHAI =  N'Nam' then 'Mr.' + TENNV
			when PHAI = N' Nữ' then 'Mrs.' + TENNV
			else 
			'free sex:' + TENNV
		 end as ten,
         PHAI
 from NHANVIEN

 select TENNV , LUONG,
	case
	  when Luong <25000 and LUONG>0 then LUONG*0.1
	  when Luong >=25000 and LUONG<30000 then LUONG*0.12
	  when Luong >=30000 and LUONG<40000 then LUONG*0.15
	  when Luong >=40000 and LUONG<50000 then LUONG*0.2
	  when Luong >=50000  then LUONG*0.25
	end as thue
 from NHANVIEN
 -- lab4 bai1 
 select MANV, TENNV, PHG,LUONG,
	case
	when LUONG < ( select AVG (LUONG) from NHANVIEN NV1
										where NV1.PHG=NV.PHG
											) then N'tăng lương'
	else N'không tăng lương'
	end as 'Ketqua'
 from NHANVIEN NV
 --vIẾT phương trình nhân viên dựa vào mức lương.
 --	Nếu lương nhân viên nhỏ hơn trung bình lương mà nhân viên đó đang làm việc 
 -- thì xếp loại 'nhân viên', ngược lại là xếp loại 'trưởng phòng'

 select MANV, TENNV, PHG,LUONG,
	case
	when LUONG < ( select AVG (LUONG) from NHANVIEN NV1
										where NV1.PHG=NV.PHG
											) then N'Nhân viên'
	else N'Trưởng phòng'
	end as 'Ketqua'
 from NHANVIEN NV
 --------------------------------PHẦN 2------------------------
--III vòng lặp 
--1 cú pháp lặp 
--while(Điều kiện)
--Begin
--Các lệnh 
--[Break/continue] -- gặp break dừng lặp 
				 -- gặp continue thì chạy ngay đến lần lặp tiếp theo 
--end -- VD1:tính tổng từ 1-100
declare @tong int = 0, @i int  = 1
while(@i<=10)
begin
if(@i=5) break -- i=5 thì dừng 
	set @tong = @tong+@i
	set @i = @i +2
end
select @tong
--2. xử lý lỗi try.....cast
BEGIN TRY
--KHỐI LỆNH
END TRY 

BEGIN CATCH
--CÁC SỬ LÝ LỖI
END CATCH
--VD1

BEGIN TRY
print N'Điểm của bạn là' +10
END TRY 

BEGIN CATCH
print N'Gặp lỗi:'
+ cast(Error_number() as nvarchar)
+ ' ' +  Error_message()
END CATCH
--VD2  thực hiện chèn thêm dữ liệu vào bảng phòng ban theo 2 bước 
-- nhận thông báo "Thêm duex liệu thành công " từ khối try 
-- chèn sai dữ liệu có thông báo "Thêm dữ liệu thất bại " từ khối catch


BEGIN TRY
	insert into PHONGBAN
	values (N'ALO',1,'001','1990-03-01')
	print N'Thêm dữ liệu thành công'
END TRY 
BEGIN CATCH
    print N'thêm dữ liệu thất bại '-- + Error_massage()
END CATCH
select* from PHONGBAN
--3.Raiserror:Thông báo lỗi
-- cú pháp :Raiserror (Lời thông báo_ mức độ_trạng thái)
--VD
IF(3>5)
    print 'xem lại đi'
else
Begin 
	raiserror(N'bạn sai rồi',1,1)
end
-------------Bai tập tính điểm------------------------------------

BEGIN TRY
	insert into THANNHAN(MA_NVIEN,TENTN,PHAI,NGSINH,QUANHE)
	values ('002',N'trung',N'Nam','1990-03-01',N'Bố')
	print N'Thêm dữ liệu thành công'
END TRY 
BEGIN CATCH
    print N'thêm dữ liệu thất bại '-- + Error_massage()
END CATCH
select * 
from THANNHAN
--b2
  select MANV,TENNV,IIF(PHAI like 'Nam','Mr.','Mrs.') as 'Gioi tinh',NGSINH,YEAR(GETDATE()) - YEAR(NGSINH) as 'Tuoi',
	   case
				when (YEAR(GETDATE()) - YEAR(NGSINH))<18 then 'Tre em'
				when (YEAR(GETDATE()) - YEAR(NGSINH)) between 18 and 60 then 'Lao dong'
				else
					'Tuoi gia'
		END as 'Status'
from NHANVIEN