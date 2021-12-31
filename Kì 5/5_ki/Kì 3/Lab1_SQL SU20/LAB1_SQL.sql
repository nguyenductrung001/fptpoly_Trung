 use QLDA
go


--1. Tìm các nhân viên làm việc ở phòng số 4
select *
from NHANVIEN
Where PHG = 4
--2. Tìm các nhân viên có mức lương trên 30000
select *
from NHANVIEN
where LUONG >30000
--3. Tìm các nhân viên có mức lương trên 25,000 ở phòng 4 hoặc các nhân
--viên có mức lương trên 30,000 ở phòng 5
select * 
from NHANVIEN
Where LUONG > 25000 and PHG = 4 or LUONG  >30000 and PHG = 5
--4. Cho biết họ tên đầy đủ của các nhân viên ở TP HCM
select HONV + TENLOT + TENNV
from NHANVIEN
where  DCHI like '%TP HCM%'
--5. Cho biết họ tên đầy đủ của các nhân viên có họ bắt đầu bằng ký tự
--'N'
select HONV +''+ TENLOT+'' + TENNV as Hoten
from NHANVIEN
where HONV like 'N%'
--6. Cho biết ngày sinh và địa chỉ của nhân viên Dinh Ba Tien.
select NGSINH , DCHI
from NHANVIEN
where HONV +''+ TENLOT+'' + TENNV like N' Dinh  Ba  Tien'
--7 cho biet thong tin ve nhan than cua nhan vien 
--Manv, ho ten , dia chi, ten nhan than, phai, quan he
select NHANVIEN.MANV, HONV +''+ TENLOT+'' + TENNV as Hoten, NHANVIEN.NGSINH,DCHI,NHANVIEN.PHAI,QUANHE
from NHANVIEN inner join THANNHAN on NHANVIEN.MANV=THANNHAN.MA_NVIEN
--8 cho biet so nhan nhan cua nhan vien , ke ca nhung nhan vien chua cos nhan than nao
-- Manv , hoten,so nhan than
select MA_NVIEN, COUNT(MA_NVIEN) as 'Tong'
	 from THANNHAN  
	 group by MA_NVIEN