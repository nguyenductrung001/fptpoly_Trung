use QLDA
go
--I. Slide 2(Buổi 3): sử dụng CSDL QLDA trả lời các câu hỏi sau
--1. Cho biết thông tin về Phòng Ban
select *
from PHONGBAN
--2. Cho biết thông tin về Nhân Viên
select *
from NHANVIEN
--3. Cho biết thông tin về Công việc
select *
from CONGVIEC
--4. Cho biết thông tin về Nhân Viên và phòng Ban của họ: Mã NV, họ tên, ngày sinh, địa
--chỉ, mã phòng, tên phòng, tên trưởng phòng
select NHANVIEN.MANV,HONV +' '+ TENLOT+' '+TENNV as Hoten,NGSINH,DCHI,PHONGBAN.MAPHG,TENPHG,TRPHG
from NHANVIEN inner join PHONGBAN on NHANVIEN.PHG=PHONGBAN.MAPHG
--5. Giống câu 4, nhưng chỉ đưa ra thông tin các nhân viên của phòng Nghiên cứu.
select NHANVIEN.MANV,HONV +' '+ TENLOT+' '+TENNV as Hoten,NGSINH,DCHI,PHONGBAN.MAPHG,TENPHG,TRPHG
from NHANVIEN inner join PHONGBAN on NHANVIEN.PHG=PHONGBAN.MAPHG
where TENPHG like N'Nghiên cứu'
--6. Cho biết thông tin về nhân viên và công việc của họ: MaNV, họ tên, mã phòng, Thời
--gian, tên công việc
select MANV,HONV +' '+ TENLOT+' '+TENNV as Hoten,PHG,THOIGIAN,TEN_CONG_VIEC
from NHANVIEN inner join PHANCONG on NHANVIEN.MANV=PHANCONG.MA_NVIEN
              inner join CONGVIEC on PHANCONG.MADA = CONGVIEC.MADA and PHANCONG.STT = CONGVIEC.STT
--7. Cho biết thonong tin công việc của phòng Điều hành: MaNV, họ tên, mã phòng, Thời
--gian, tên công việc
select MANV,HONV +' '+ TENLOT+' '+TENNV as Hoten,PHG,THOIGIAN,TEN_CONG_VIEC
from NHANVIEN inner join PHANCONG on NHANVIEN.MANV=PHANCONG.MA_NVIEN
              inner join CONGVIEC on PHANCONG.MADA = CONGVIEC.MADA and PHANCONG.STT = CONGVIEC.STT
where PHG = 4
--8. Cho biết thông tin về Đề án của các phòng ban, kể cả những phòng ban: mã phòng, tên
--phòng, tên đề án, địa điểm đề án.
select PHONGBAN.MAPHG,TENPHG,TENDEAN,DDIEM_DA
from PHONGBAN left join DEAN on PHONGBAN.MAPHG=DEAN.PHONG
--9. Cho biết thông tin về số đề án của mỗi phòng, kể cả những phòng không có đề án nào:
--Mã phòng, tên phòng, tổng số đề án.
select PHONGBAN.MAPHG,TENPHG,count(MADA)as tongdean
from PHONGBAN left join DEAN on PHONGBAN.MAPHG=DEAN.PHONG
group by PHONGBAN.MAPHG,TENPHG
--10. Cho biết thông tin các phòng không có đề án nào: Mã phòng, tên phòng.
select PHONGBAN.MAPHG,TENPHG,count(MADA)as tongdean
from PHONGBAN left join DEAN on PHONGBAN.MAPHG=DEAN.PHONG
group by PHONGBAN.MAPHG,TENPHG
having count(MADA) = 0
--11. Cho biết thông tin về số nhân viên của từng phòng ban, kể cả những phòng ban không có
--nhân viên nào: mã phòng, tên phòng, số nhân viên.
select PHONGBAN.MAPHG,TENPHG,COUNT(NHANVIEN.PHG) as sonhanvien
from NHANVIEN right outer join PHONGBAN on NHANVIEN.PHG=PHONGBAN.MAPHG
group by PHONGBAN.MAPHG,TENPHG
--12. Thêm cột quốc tịch vào bảng Nhân viên với giá trị mặc định là Việt Nam\
Alter table NHANVIEN
add QuocTich nvarchar(10)
constraint d_nhanvien_quoctich
default N'Việt Nam' with values
--13. Cập nhật giới tính của nhân viên có mã 002 là nam
update NHANVIEN
set PHAI = N'Nam'
where MANV like '002'
--14. Thêm Nhân thân vợ cho nhân viên 017, các thông tin tự nhập
INSERT [dbo].[THANNHAN] ([MA_NVIEN], [TENTN], [PHAI], [NGSINH], [QUANHE]) VALUES (N'017', N'Phương', N'Nữ', CAST(N'1957-05-05' AS Date), N'Vợ Chồng')
--15. Cho biết mức lương cao nhất của nhân viên
select top 1 LUONG
from NHANVIEN
order by LUONG desc
--16. Cho biết mức lương trung bình của nhân viên
(select sum(LUONG)/(select COUNT(MANV)from NHANVIEN)
from NHANVIEN)